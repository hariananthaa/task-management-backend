package com.hsk.projectservice.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;


public class ResponsePaginationUtil {

    @Value("${spring.application.name}")
    private static String serviceName;

    public static ResponsePaginationData responsePaginationConverter(Object object, Long totalElements, int totalPages, int pageNumber) {

        ResponsePaginationData responsePaginationData;

        if (object instanceof ResponsePaginationData) {
            responsePaginationData = (ResponsePaginationData) object;
        } else {
            responsePaginationData = new ResponsePaginationData();
            responsePaginationData.setData(object);
            responsePaginationData.setTotalElements(totalElements);
            responsePaginationData.setTotalPages(totalPages);
            responsePaginationData.setPageNumber(pageNumber);
            responsePaginationData.setStatus(HttpStatus.OK.value());
            responsePaginationData.setResult(true);
        }
        responsePaginationData.setServiceName(serviceName);
        return responsePaginationData;
    }

}
