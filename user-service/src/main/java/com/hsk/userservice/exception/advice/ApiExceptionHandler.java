package com.hsk.userservice.exception.advice;


import com.hsk.userservice.exception.AlreadyExistingException;
import com.hsk.userservice.exception.NotFoundException;
import com.hsk.userservice.exception.ValidationException;
import com.hsk.userservice.exception.VerificationFailedException;
import com.hsk.userservice.utils.ResponseData;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @Value("${spring.application.name}")
    private String serviceName;

    @ExceptionHandler(value = {AlreadyExistingException.class})
    protected ResponseEntity<ResponseData> handleException(AlreadyExistingException e) {
        ResponseData responseData = buildExceptionResponseData(e.getMessage(), HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        return ResponseEntity.ok().body(responseData);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ResponseData> handleException(NotFoundException e) {
        ResponseData responseData = buildExceptionResponseData(e.getMessage(), HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        return ResponseEntity.ok().body(responseData);
    }

    @ExceptionHandler(value = {VerificationFailedException.class})
    protected ResponseEntity<ResponseData> handleException(VerificationFailedException e) {
        ResponseData responseData = buildExceptionResponseData(e.getMessage(), HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        return ResponseEntity.ok().body(responseData);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<ResponseData> handleException(ConstraintViolationException e) {
        String errorMessage = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse("Invalid input.");
        ResponseData responseData = buildExceptionResponseData(errorMessage, HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        return ResponseEntity.ok().body(responseData);
    }

    @ExceptionHandler(value = {ValidationException.class})
    protected ResponseEntity<ResponseData> handleException(ValidationException e) {
        ResponseData responseData = buildExceptionResponseData(e.getMessage(), HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        return ResponseEntity.ok().body(responseData);
    }

    @ExceptionHandler(value = {UnexpectedTypeException.class})
    protected ResponseEntity<ResponseData> handleException(UnexpectedTypeException e) {
        ResponseData responseData = buildExceptionResponseData(e.getMessage(), HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        return ResponseEntity.ok().body(responseData);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ResponseData> handleException(Exception e) {
        ResponseData responseData = buildExceptionResponseData("Something went wrong!", HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        return ResponseEntity.ok().body(responseData);
    }

    protected ResponseData buildExceptionResponseData(String message, Integer status) {
        ResponseData responseData = new ResponseData<>();
        responseData.setMessage(message);
        responseData.setData(null);
        responseData.setStatus(status);
        responseData.setServiceName(serviceName);
        responseData.setResult(false);
        return responseData;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        String errorMessage = fieldError.getDefaultMessage();
        ResponseData responseData = buildExceptionResponseData(errorMessage, HttpStatus.OK.value());
        return ResponseEntity.ok().body(responseData);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ResponseData responseData = buildExceptionResponseData(e.getParameterName() + " is invalid", HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        return ResponseEntity.ok().body(responseData);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ResponseData responseData = buildExceptionResponseData("Invalid input.", HttpStatus.OK.value());
        log.error(e.getStackTrace().toString());
        log.error(e.toString());
        return ResponseEntity.ok().body(responseData);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<ResponseData> handleException(MethodArgumentTypeMismatchException e) {
        log.error(e.getStackTrace().toString());
        ResponseData responseData = buildExceptionResponseData("Invalid input type.", HttpStatus.OK.value());
        return ResponseEntity.ok().body(responseData);
    }
}
