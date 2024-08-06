package com.abelalvarz.ordershipment.exceptions;

import com.abelalvarz.ordershipment.dtos.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
   public ResponseEntity<Response> handleAllExceptions(Exception e){
       Response response = Response.builder()
               .success(false)
               .data(null)
               .statusCode(HttpStatus.BAD_REQUEST.value())
               .message("Error: "+e.getMessage())
               .build();
       return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
   }
}
