package edu.baylor.ecs.ems.service;

import edu.baylor.ecs.ems.dto.ChoiceEmsDto;
import edu.baylor.ecs.ems.dto.ChoiceQmsDto;
import edu.baylor.ecs.ems.dto.QuestionEmsDto;
import edu.baylor.ecs.ems.dto.QuestionQmsDto;
import edu.baylor.ecs.ems.model.Choice;
import edu.baylor.ecs.ems.dto.*;
import edu.baylor.ecs.ems.model.Exam;
import edu.baylor.ecs.ems.model.Question;
import edu.baylor.ecs.ems.repository.ChoiceRepository;
import edu.baylor.ecs.ems.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChoiceRepository choiceRepository;


    public List<Question> getAllByExam(Integer examId) {
        return this.questionRepository.getAllByExam_Id(examId);
    }

    public List<QuestionEmsDto> saveAllQuestionQmsDtos(List<QuestionQmsDto> questionQmsDtos, Exam exam) {

        //QuestionQmsDto -> Question
        this.questionsFromQmsToModel(questionQmsDtos, exam);

        // Save Questions
        List<Question> questions = this.questionRepository.getAllByExam_Id(exam.getId());
        for (Question q: questions
             ) {
            q.setChoices(choiceRepository.findByQuestionId(q.getId()));
        }

        // Questions -> QuestionEmsDto
        List<QuestionEmsDto> questionEmsDtos = this.questionsFromModelToEms(questions);

        return questionEmsDtos;
    }

    public List<QuestionEmsDto> getAllByExamPruned(Exam exam) {
        List<Question> questions = this.questionRepository.getAllByExam_Id(exam.getId());
        return questionsFromModelToEms(questions);
    }


    public List<QuestionEmsDto> questionsFromModelToEms(List<Question> questions){
        List<QuestionEmsDto> questionEmsDtos = new ArrayList<>();
        for (Question q: questions
        ) {
            QuestionEmsDto questionEmsDto = new QuestionEmsDto();
            questionEmsDto.setId(q.getId());
            questionEmsDto.setBody(q.getBody());
            questionEmsDto.setCode(q.getCode());
            List<ChoiceEmsDto> choiceEmsDtos = choicesFromModelToEms(q.getChoices());
            questionEmsDto.setChoices(choiceEmsDtos);
            questionEmsDtos.add(questionEmsDto);
        }
        return questionEmsDtos;
    }

    private List<ChoiceEmsDto> choicesFromModelToEms(List<Choice> choices) {
        //Erase correct
        List<ChoiceEmsDto> choiceEmsDtos = new ArrayList<>();
        for (Choice ch: choices
             ) {
            ChoiceEmsDto choiceEmsDto = new ChoiceEmsDto();
            choiceEmsDto.setBody(ch.getBody());
            choiceEmsDto.setChosen(ch.isChosen());
            choiceEmsDto.setId(ch.getId());
            choiceEmsDtos.add(choiceEmsDto);
        }
        return choiceEmsDtos;
    }

    public List<Question> questionsFromQmsToModel(List<QuestionQmsDto> questionQmsDtos, Exam exam){
        List<Question> questions = new ArrayList<>();
        for (QuestionQmsDto q: questionQmsDtos
        ) {
            Question question = new Question();
            question.setBody(q.getBody());
            question.setCode(q.getCode().getBody());
            question.setExam(exam);
            question = this.questionRepository.save(question);
            Set<Choice> choices = choicesFromQmsToModel(q.getChoices(), question);
            choiceRepository.saveAll(choices);
            //question.setChoices(choices);
            //questions.add(question);
        }
        return questions;
    }

    private Set<Choice> choicesFromQmsToModel(List<ChoiceQmsDto> choiceQmsDtos, Question question) {
        Set<Choice> choices = new HashSet<>();
        for (ChoiceQmsDto ch: choiceQmsDtos
             ) {
            Choice choice = new Choice();
            //choice.setId(ch.getId());
            choice.setCorrect(ch.isCorrect());
            choice.setBody(ch.getBody());
            choice.setQuestion(question);
            choices.add(choice);
        }
        return choices;
    }



}
