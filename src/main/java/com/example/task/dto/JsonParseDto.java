package com.example.task.dto;

import lombok.Data;

@Data
public class JsonParseDto {
    private String convertFrom;
    private String convertTo;
    private Double action;
}
