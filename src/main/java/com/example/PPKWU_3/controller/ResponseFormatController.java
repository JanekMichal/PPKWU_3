package com.example.PPKWU_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("response_format_controller/")
public class ResponseFormatController {

    @GetMapping("plain_text")
    public String getEmployees()
    {
        final String uri = "http://localhost:8080/string_analyzer/lower_case/gafdsgdsqa";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

       return result;
    }
}
