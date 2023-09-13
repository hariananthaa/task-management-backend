package com.hsk.userservice.utils;

import java.io.Serializable;

public class ResponsePaginationData<T> implements Serializable {
    private int status = 200;
    private T data;
    private String message = "";
    private String serviceName;
    private Boolean result;
    private int totalPages;
    private Long totalElements;
    private int pageNumber;

    public int getTotalPages() {
        return totalPages;
    }

    public ResponsePaginationData<T> setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public ResponsePaginationData<T> setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public ResponsePaginationData<T> setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ResponsePaginationData<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public boolean getResult() {
        return result;
    }

    public ResponsePaginationData<T> setResult(boolean result) {
        this.result = result;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponsePaginationData<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponsePaginationData<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getServiceName() {
        return serviceName;
    }

    public ResponsePaginationData<T> setServiceName(String serviceName) {
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

