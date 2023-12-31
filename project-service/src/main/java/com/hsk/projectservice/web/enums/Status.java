package com.hsk.projectservice.web.enums;

import org.springframework.beans.factory.annotation.Value;

public enum Status {

    @Value("Open")
    OPEN,

    @Value("In Progress")
    IN_PROGRESS,

    @Value("Done")
    DONE
}
