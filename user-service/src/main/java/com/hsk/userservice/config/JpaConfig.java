package com.hsk.userservice.config;

import com.hsk.userservice.persistent.entity.base.ApplicationAuditorAware;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(basePackages = {"com.hsk.userservice.persistent.repository"})
@EntityScan(basePackages = {"com.hsk.userservice.persistent.entity"})
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new ApplicationAuditorAware();
    }
}
