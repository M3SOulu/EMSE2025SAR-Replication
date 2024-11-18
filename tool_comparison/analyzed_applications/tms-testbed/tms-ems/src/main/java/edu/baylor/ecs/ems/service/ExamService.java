package edu.baylor.ecs.ems.service;

import edu.baylor.ecs.ems.dto.ExamDto;
import edu.baylor.ecs.ems.dto.QuestionEmsDto;
import edu.baylor.ecs.ems.dto.QuestionQmsDto;
import edu.baylor.ecs.ems.model.Choice;
import edu.baylor.ecs.ems.model.ExamStatus;
import edu.baylor.ecs.ems.dto.*;
import edu.baylor.ecs.ems.model.Exam;
import edu.baylor.ecs.ems.model.Question;
import edu.baylor.ecs.ems.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private QmsService qmsService;

    @Autowired
    private QuestionService questionService;

    public Optional<Exam> findById(Integer id) {
        return this.examRepository.findById(id);
    }

    public List<Exam> findAllExams() {
        return this.examRepository.findAll();
    }

    public boolean isExamExist(Integer examId, Integer examineeId) {
        return this.examRepository.existsByExamineeAndId(examineeId, examId);
    }

    public Exam submitExam(Integer examId) {
        Optional<Exam> optionalExam = this.findById(examId);
        if (!optionalExam.isPresent()) {
            return null;
        }
        Exam exam = optionalExam.get();
        exam.setStatus(ExamStatus.DONE);
        return this.examRepository.saveAndFlush(exam);
    }

    public Exam saveExam(ExamDto examDto) {
        Exam exam = new Exam(examDto);
        exam.setStatus(ExamStatus.INIT);
        return this.examRepository.saveAndFlush(exam);
    }


    public List<QuestionEmsDto> takeExam(Integer id) {
        Optional<Exam> optionalExam = this.findById(id);
        if (!optionalExam.isPresent()) {
            return null;
        }
        Exam exam = optionalExam.get();
        //ToDo: Check if exam.getExaminee() == currentlyLoggedUser
        ExamStatus examStatus = exam.getStatus();
        if (examStatus.equals(ExamStatus.INIT)){
            return handleExamInit(exam);
        } else if (examStatus.equals(ExamStatus.PROGRESS)){
            return handleExamProgress(exam);

        } else {
            // DONE
            return null;
        }
    }

    private List<QuestionEmsDto> handleExamProgress(Exam exam) {
        // IN PROGRESS
        Date currentDate = new Date();
        if (currentDate.before(exam.getExamDate()) || currentDate.equals(exam.getExamDate())){
            // Return questions associated with this exam && prune them
            return this.questionService.getAllByExamPruned(exam);
        } else {
            // IN PROGRESS BUT SUBMITTED AFTER DEADLINE
            if (!exam.getStatus().equals(ExamStatus.DONE)){
                // update exam to DONE
                exam.setStatus(ExamStatus.DONE);

                this.examRepository.saveAndFlush(exam);
                // BAD REQUEST
                return null;
            }
        }

        return null;
    }




    private List<QuestionEmsDto> handleExamInit(Exam exam) {

        // QMS get questions / choices
        List<QuestionQmsDto> questionQmsDtos = this.qmsService.getQuestions(exam.getConfigurationId());

        exam = setExamToProgress(exam);
        exam = setExamDate(exam);
        exam.setSum(questionQmsDtos.size());
        exam = this.examRepository.saveAndFlush(exam);

        // Persist to DB + Retrieve from DB + clear data
        List<QuestionEmsDto> questions = this.questionService.saveAllQuestionQmsDtos(questionQmsDtos, exam);
        // Update Exam to PROGRESS & set examDATE to currentDate + 30 min


        return questions;
    }

    private Exam setExamDate(Exam exam) {
        long ONE_MINUTE_IN_MILLIS=60000;
        Calendar date = Calendar.getInstance();
        long t = date.getTimeInMillis();
        Date afterAdding=new Date(t + (30 * ONE_MINUTE_IN_MILLIS));
        exam.setExamDate(afterAdding);
        return exam;
    }

    private Exam setExamToProgress(Exam exam) {
        exam.setStatus(ExamStatus.PROGRESS);
        return exam;
    }


    public String finishExam(Integer id) {
        Optional<Exam> optionalExam = this.findById(id);
        if (optionalExam.isPresent()) {
            return "Not found";
        }
        Exam exam = optionalExam.get();
        Date currentDate = new Date();
        if (currentDate.before(exam.getExamDate()) || currentDate.equals(exam.getExamDate())){
            exam.setStatus(ExamStatus.DONE);
            List<Question> questions = this.questionService.getAllByExam(exam.getId());
            exam.setSum(questions.size());
            Integer correct = 0;
            for (Question q: questions
                 ) {
                boolean same = true;
                for (Choice ch: q.getChoices()
                     ) {
                    if (!(ch.isCorrect() && ch.isChosen())){
                        same = false;
                        break;
                    }
                }
                if (same) {
                    correct = correct + 1;
                }
            }
            exam.setCorrect(correct);
            examRepository.saveAndFlush(exam);
            return "OK";
        } else {
            // BAD REQUEST
            return "Forbidden";
        }

    }

    public boolean deleteINITExam(Integer id) {
        Exam exam = examRepository.findById(id).orElse(null);
        if (exam == null) {
            return false;
        } else if (exam.getStatus() != ExamStatus.INIT) {
            return false;
        }
        examRepository.delete(exam);
        return true;
    }

    public List<Question> getQuestionsForExam(Integer id) {
        return questionService.getAllByExam(id);
    }
}
