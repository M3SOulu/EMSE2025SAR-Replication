package edu.baylor.ecs.ems.service;

import edu.baylor.ecs.ems.dto.QuestionQmsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QmsService {

    @Autowired
    private QuestionService questionService;

    private final RestTemplate restTemplate;

    public QmsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<QuestionQmsDto> getQuestions(Integer configurationId) {
        //ToDo: call QMS
        // http://129.62.148.179:12345/test?configId=1
//        ResponseEntity<Object[]> objects = restTemplate.getForEntity("http://129.62.148.179:12345/test?configId="+configurationId, Object[].class);
        ResponseEntity<List<QuestionQmsDto>> qqd = this.restTemplate.exchange("http://129.62.148.179:12345/test?configId="+configurationId, HttpMethod.GET, null, new ParameterizedTypeReference<List<QuestionQmsDto>>() {
        });
//        List<QuestionQmsDto> qqd = new ArrayList<>();
//        Arrays.stream(objects.getBody()).forEach(o -> {
//            qqd.add((QuestionQmsDto) o);
//        });
        return qqd.getBody();

//        List<QuestionQmsDto> questionDtos = new ArrayList<>();
//        questionDtos.add(new QuestionQmsDto());
//        return questionDtos;
    }


}
