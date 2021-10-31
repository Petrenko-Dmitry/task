package com.example.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Request {
    private DistanceDto distance;
    @JsonProperty(value = "convert_to")
    private String convertTo;
}
