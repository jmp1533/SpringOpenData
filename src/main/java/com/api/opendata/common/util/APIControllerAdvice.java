package com.api.opendata.common.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.api.opendata.controller.KakaoChatbotController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice(basePackageClasses = KakaoChatbotController.class)
public class APIControllerAdvice {

    // 예외 잡는 메서드
    @ExceptionHandler(value = Exception.class) // 모든 예외
    public ResponseEntity exception(Exception e) {
        System.out.println(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    // 특정 예외를 처리하는 메서드
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        // 콘솔창에 친절한 에러 출력
        bindingResult.getAllErrors().forEach(error -> {
            FieldError fieldError = (FieldError) error;

            String fieldName = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            String value = fieldError.getRejectedValue().toString();
            System.out.println(fieldName);
            System.out.println(message);
            System.out.println(value);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    // 추가적인 에러 처리
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException e) {
        e.getConstraintViolations().forEach(error ->{
            System.out.println(error);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    // 추가적인 에러 처리
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}