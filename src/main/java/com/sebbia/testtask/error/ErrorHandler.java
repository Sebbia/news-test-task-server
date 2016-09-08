package com.sebbia.testtask.error;

import com.sebbia.testtask.base.response.ErrorResponse;
import com.sebbia.testtask.base.response.Response;
import com.sebbia.testtask.error.exception.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorHandler {

    private Log logger = LogFactory.getLog(getClass());

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResponseEntity<Response> apiException(ApiException exception) {
        return new ResponseEntity<Response>(new ErrorResponse(exception), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> generalError(Exception exception) {
        logger.error("Server failed to parse request", exception);
        return new ResponseEntity<Response>(new ErrorResponse(new InternalErrorException()), HttpStatus.OK);
    }

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<Response> wrongValueTypeInJson(TypeMismatchException exception) {
        String message = "Type mismatch exception: '" + exception.getValue() + "' does not look like something of " + exception.getRequiredType().getSimpleName() + " type.";
        return new ResponseEntity<Response>(new ErrorResponse(new InvalidParametersFormatException(message)), HttpStatus.OK);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Response> wrongHttpMethod(HttpRequestMethodNotSupportedException exception) {
        return new ResponseEntity<Response>(new ErrorResponse(new InvalidHttpMethodException("Invalid http method: " + exception.getMethod())), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Response> missingRequiredParamException(MissingServletRequestParameterException exception) {
        return new ResponseEntity<Response>(new ErrorResponse(new MissingParameterException("Missing required parameter: " + exception.getParameterName())), HttpStatus.OK);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Response> methodNotFoundExeption(NoHandlerFoundException exception) {
        return new ResponseEntity<Response>(new ErrorResponse(new MethodNotFoundException(exception.getRequestURL(), exception.getHttpMethod())), HttpStatus.NOT_FOUND);
    }

}
