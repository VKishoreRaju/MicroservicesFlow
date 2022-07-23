package com.kr.poc.common.handler;


import com.kr.poc.common.exception.ApplicationException;
import com.kr.poc.common.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.management.ServiceNotFoundException;
import java.util.Date;

@ControllerAdvice
@ResponseStatus
@Slf4j
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ApplicationException> handleException(ServiceNotFoundException exception, WebRequest request){
        log.info("*****START OF CommonExceptionHandler==>handleException****");
        ApplicationException applicationException= ApplicationException.builder().message(exception.getMessage())
                .code(HttpStatus.NOT_FOUND.toString()).
                date(new Date()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(applicationException);
    }

}
