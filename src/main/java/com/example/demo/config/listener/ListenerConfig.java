package com.example.demo.config.listener;

import com.example.demo.config.filter.CustomizeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EventListener;

/**
 * @Author yaKun.shi
 */
@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean registerListener() {
        ServletListenerRegistrationBean<EventListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        servletListenerRegistrationBean.setListener(new CustomizeListener());
        return servletListenerRegistrationBean;
    }
}
