package org.stephane.club.config.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.stephane.club.share.exception.DataExistsException;
import org.stephane.club.share.exception.DataNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalErrorHandler {
    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dataNotFoundHandler(HttpServletRequest request,
                                   HttpServletResponse response, Exception ex) {

        // do something with request or response

        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(DataExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dataExistsHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception ex) {

        // do something with request or response

        return ex.getMessage();
    }
}
