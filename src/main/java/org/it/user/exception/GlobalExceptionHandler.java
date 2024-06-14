package org.it.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.it.user.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<Object> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error("System Error, please try again or contact admin.");
    }

}
