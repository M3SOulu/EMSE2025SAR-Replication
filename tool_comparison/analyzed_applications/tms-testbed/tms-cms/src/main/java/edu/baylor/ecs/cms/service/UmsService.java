package edu.baylor.ecs.cms.service;

import edu.baylor.ecs.cms.dto.EmailDto;
import edu.baylor.ecs.cms.model.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Service
public class UmsService {

    @Value("${ums.ip}")
    private String umsIp;

    @Value("${ums.id}")
    private String id;

    @Value("${ums.email}")
    private String email;

    private final RestTemplate restTemplate;

    public UmsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

//    public ResponseEntity<Object> isEmailValid(String email){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(umsIp);
//        stringBuilder.append(email);
//        stringBuilder.append("?email=");
//        stringBuilder.append(email.replace("@", "%40"));
//        Object object = restTemplate.getForEntity(umsIp + email, Integer.class);
//
//        return new ResponseEntity.ok(object);
//    }

    public EmailDto isEmailValid(String email, String auth) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(umsIp);
        stringBuilder.append(email);
        stringBuilder.append("?email=");
        stringBuilder.append(email.replace("@", "%40"));
//        Object object = restTemplate.getForEntity(umsIp + this.email + email, Integer.class);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", auth);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<String> re = this.restTemplate.exchange(umsIp + this.email + email, HttpMethod.GET, request, String.class);
        EmailDto emailDto = new EmailDto();
        emailDto.setEmail(re.getBody());
        return emailDto;
//
//        restTemplate.exchange
//                (uri, HttpMethod.POST, new HttpEntity<T>(createHeaders(username, password)), Integer.class);
//        return ResponseEntity.ok(object);
    }

    public List<Object> getAllUsers(String auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", auth);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Object[]> re = this.restTemplate.exchange(umsIp + "userinfo/users", HttpMethod.GET, request, Object[].class);
        return Arrays.asList(re.getBody());
    }

    public HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }

    public String getExamineeId(String username, String auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", auth);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> resp = this.restTemplate.exchange(umsIp + "userinfo/userIdByUsername/" + username, HttpMethod.GET, request, String.class);
        return resp.getBody();
    }

    public User getExamineeInfo(String id, String auth) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", auth);
        HttpEntity<User> request = new HttpEntity<>(headers);
        ResponseEntity<User> resp = this.restTemplate.exchange(umsIp + "userinfo/userById/" + id, HttpMethod.GET, request, User.class);
        return resp.getBody();
    }

    public Boolean isExamineeIdValid(Integer id){
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(umsIp);
//        stringBuilder.append(id);
//        stringBuilder.append("?id=");
//        stringBuilder.append(id);
//        return restTemplate.getForEntity(umsIp + validContext, Integer.class);
        return Boolean.TRUE;
    }


    public Integer getCurrentLoggedInUser(){
        return 1;
    }

}
