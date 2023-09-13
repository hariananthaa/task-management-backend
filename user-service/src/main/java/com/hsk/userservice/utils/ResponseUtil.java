package com.hsk.userservice.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

public class ResponseUtil {

    @Value("${spring.application.name}")
    private static String serviceName;

    public static ResponseData responseConverter(Object object) {

        ResponseData responseData;

        if (object instanceof ResponseData) {
            responseData = (ResponseData) object;
        } else {
            responseData = new ResponseData();
            responseData.setData(object);
            responseData.setStatus(HttpStatus.OK.value());
            responseData.setResult(true);
        }
        responseData.setServiceName(serviceName);
        return responseData;
    }

    public static ResponseData buildExceptionResponseData(String message, Integer status,String serviceName) {
        ResponseData responseData = new ResponseData<>();
        responseData.setMessage(message);
        responseData.setData(null);
        responseData.setStatus(status);
        responseData.setServiceName(serviceName);
        responseData.setResult(false);
        return responseData;
    }

}
