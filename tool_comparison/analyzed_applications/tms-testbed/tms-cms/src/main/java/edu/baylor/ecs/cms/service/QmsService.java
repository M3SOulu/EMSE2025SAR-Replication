package edu.baylor.ecs.cms.service;

import edu.baylor.ecs.cms.dto.CategoryInfoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class QmsService {

    @Value("${qms.ip}")
    private String qmsIp;

    @Value("${qms.categoryinfo}")
    private String categoryInfoContext;

    @Value("${qms.configuration}")
    private String configurationContext;

    private final RestTemplate restTemplate;

    public QmsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Object> getCategoryInfoDtos(){
        String categoryInfoPath = qmsIp + categoryInfoContext;
        ResponseEntity<Object[]> tmp = this.restTemplate.getForEntity(categoryInfoPath, Object[].class);
        List<CategoryInfoDto> categoryInfoDtos = new ArrayList<>();
//        for(CategoryInfoDto c:tmp.getBody()) {
//            categoryInfoDtos.add(c);
//            System.out.println("result = " + c.getDescription());
//        }

        Object[] objects = tmp.getBody();
        return Arrays.asList(objects);
    }

    public ResponseEntity<Object> createConfiguration(Object object) {
        Object obj = this.restTemplate.postForObject(qmsIp + configurationContext, object, Object.class);
        return ResponseEntity.ok(obj);
    }

    public ResponseEntity<Object[]> getConfigurations() {
        return this.restTemplate.getForEntity(qmsIp + configurationContext, Object[].class);
    }
}
