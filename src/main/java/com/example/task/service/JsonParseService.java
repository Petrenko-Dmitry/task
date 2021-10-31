package com.example.task.service;

import com.example.task.dto.JsonParseDto;
import com.example.task.dto.Request;
import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class JsonParseService {
    /*
    * Метод в котором считываем подходящие правило из rule.json и возвращаем ответ
    *  */
    public Double readFile(Request request) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("rule.json"));
        String line;
        String[] partOfLine;
        JsonParseDto jsonParseDto = new JsonParseDto();
        while ((line = reader.readLine()) != null) {
            partOfLine = line.split("#");

            if (!Strings.isNullOrEmpty(line)) {
                jsonParseDto.setConvertFrom(partOfLine[0]);
                jsonParseDto.setConvertTo(partOfLine[1]);
                jsonParseDto.setAction(Double.parseDouble(partOfLine[2]));

                if (jsonParseDto.getConvertFrom().equals(request.getDistance().getUnit())
                        && jsonParseDto.getConvertTo().equals(request.getConvertTo())) {
                    return request.getDistance().getValue() * jsonParseDto.getAction();
                }
            }
        }

        return null;
    }
    /*
    * Метод для добавления правила по которому будет происходить вычисление
    * */
    public void addRule(String rule) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("rule.json", true));
        bufferedWriter.newLine();
        bufferedWriter.append(rule);
        bufferedWriter.close();
    }
}
