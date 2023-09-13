package com.hsk.taskservice.helper;

import com.hsk.taskservice.api.payload.ProjectRequest;
import com.hsk.taskservice.utils.ResponseData;
import com.hsk.taskservice.utils.ResponseUtil;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class ProjectHelper {
    private final BindingResultHelper bindingResultHelper;

    public ProjectHelper(BindingResultHelper bindingResultHelper) {
        this.bindingResultHelper = bindingResultHelper;
    }

    public ResponseData addProject(ProjectRequest projectRequest, BindingResult bindingResult) {
        bindingResultHelper.processBindingResult(bindingResult);
        return ResponseUtil.responseConverter(projectRequest);
    }
}
