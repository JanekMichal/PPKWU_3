package com.example.PPKWU_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("response_format_controller/")
public class ResponseFormatController {

    private final String lowerCaseAPI = "http://localhost:8080/string_analyzer/lower_case/";
    private final String upperCaseAPI = "http://localhost:8080/string_analyzer/upper_case/";
    private final String numbersAPI = "http://localhost:8080/string_analyzer/numbers/";
    private final String specialCharactersAPI = "http://localhost:8080/string_analyzer/special_characters/";

    @GetMapping("analyze_string/{format}/{text}")
    public String getStringStatistics(@PathVariable("text") String text,
                                      @PathVariable("format") String format) {

        StringBuilder textStats = new StringBuilder();
        RestTemplate restTemplate = new RestTemplate();

        if (format.equals("csv")) {
            textStats.append("lowerCase,upperCase,numbers,specialCharacters\n");

            textStats.append(restTemplate.getForObject(lowerCaseAPI + text, String.class)).append(",");
            textStats.append(restTemplate.getForObject(upperCaseAPI + text, String.class)).append(",");
            textStats.append(restTemplate.getForObject(numbersAPI + text, String.class)).append(",");
            textStats.append(restTemplate.getForObject(specialCharactersAPI + text, String.class));
            return String.valueOf(textStats);
        } else if (format.equals("json")) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("lowerCase", restTemplate.getForObject(lowerCaseAPI + text, String.class));
            jsonObject.put("upperCase", restTemplate.getForObject(upperCaseAPI + text, String.class));
            jsonObject.put("numbers", restTemplate.getForObject(numbersAPI + text, String.class));
            jsonObject.put("specialCharacters", restTemplate.getForObject(specialCharactersAPI + text, String.class));

            return jsonObject.toJSONString();
        } else return "Cannot analyze string.";
    }
}
