package com.hsk.userservice.persistent.entity.base;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;



public class ApplicationAuditorAware implements AuditorAware<String> {

    private static final String CURRENT_AUDITOR = "system";

    @Override
    public Optional<String> getCurrentAuditor() {

        // TODO: Need to add current logged in user to auditor after Auth flow is done
        return Optional.of(CURRENT_AUDITOR);
    }

}
