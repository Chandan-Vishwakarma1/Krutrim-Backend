package com.krutrim.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto<T> {
    private int statusCode;
    private String message;
    private T data;

}