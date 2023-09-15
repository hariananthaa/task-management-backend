package com.hsk.projectservice.utils;

import java.io.Serializable;

public class ResponseData<T> implements Serializable {
    private int status = 200;
    private T data;
    private String message = "";
    private String serviceName;
    private Boolean result;

    public int getStatus() {
        return status;
    }

    public ResponseData<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public boolean getResult() {
        return result;
    }

    public ResponseData<T> setResult(boolean result) {
        this.result = result;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseData<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseData<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public ResponseData<T> setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }


    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append(status + " - ");
        sb.append("message:" + message + " - ");
        return sb.toString();
    }

    public String messageOrError() {
        StringBuilder sb = new StringBuilder();
        if (message != null && !message.equals("")) {
            sb.append(message + ";");
        }
        return sb.toString();
    }
}

