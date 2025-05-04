package com.krutrim.exception;

import com.krutrim.dto.ApiResponseDto;
import com.krutrim.entity.Enrollment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        ApiResponseDto<Void> response = new ApiResponseDto<>(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PhoneAlreadyExistsException.class)
    public ResponseEntity<ApiResponseDto<Void>> handlePhoneAlreadyExists(PhoneAlreadyExistsException ex) {
        ApiResponseDto<Void> response = new ApiResponseDto<>(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        ex.getBindingResult().getFieldErrors().forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
        ApiResponseDto<Map<String, String>> errorResponse = new ApiResponseDto<Map<String, String>>(status.value(), "Validation failed", map);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
