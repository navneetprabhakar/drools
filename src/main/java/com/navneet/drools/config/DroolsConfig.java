package com.navneet.drools.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This configuration class creates KIE container for Drools
 * @author navneetprabhakar
 *
 */
@Configuration
public class DroolsConfig {

    /**
     * This method creates KIE container bean
     * @return
     */
    @Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }
}
