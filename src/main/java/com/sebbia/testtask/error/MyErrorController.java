package com.sebbia.testtask.error;

import com.sebbia.testtask.base.response.ErrorResponse;
import com.sebbia.testtask.error.exception.InternalErrorException;
import com.sebbia.testtask.error.exception.MethodNotFoundException;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value="/error", produces="application/json")
    public ErrorResponse handle(HttpServletRequest request) {
        int statusCode = (int) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == 404) {
            return new ErrorResponse(new MethodNotFoundException(request.getContextPath(), request.getMethod()));
        } else {
            return new ErrorResponse(new InternalErrorException());
        }
    }

}
