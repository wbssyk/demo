package com.example.demo.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yaKun.shi
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CustomizeFilter());
        registration.addUrlPatterns("/*");
        registration.setName("customizeFilter");
        registration.setOrder(1);
        return registration;
    }
}
