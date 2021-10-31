package com.example.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistanceDto {
    private String unit;
    private Double value;

}
