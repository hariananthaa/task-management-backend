package com.hsk.projectservice.persistent.entity.base;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class ApplicationAuditorAware implements AuditorAware<String> {

    private static final String CURRENT_AUDITOR = "system";

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(CURRENT_AUDITOR);
    }
}
