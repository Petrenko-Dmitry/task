package com.example.task.controller;

import com.example.task.dto.DistanceDto;
import com.example.task.dto.Request;
import com.example.task.service.JsonParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DistanceController {
    @Autowired
    private JsonParseService jsonParseService;

    @PostMapping("/getDistance")
    public DistanceDto getDistance(@RequestBody Request request) throws IOException {
        Double result = jsonParseService.readFile(request);
        if (result == null) {
            return new DistanceDto(String.format("Not work with '%s' to '%s'", request.getDistance().getUnit(), request.getConvertTo()), result);
        }
        return new DistanceDto(request.getConvertTo(), result);
    }

    /*
     * При внесении правила учитываем что у нас всегда умножение
     * in#ft#0.0833333
     * где in - дюймы * 0.0833333 = ft - футы
     */
    @PostMapping("/addRule")
    public void addDistance(@RequestParam String rule) throws IOException {
        jsonParseService.addRule(rule);
    }
}
