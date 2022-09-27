package com.etoak.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrossDomainConfig {

    @Bean
    public FilterRegistrationBean crossFilter() {
        FilterRegistrationBean<CrossFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CrossFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(-100);
        return registrationBean;
    }

}
