package com.example.demo.config.listener;


import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author yaKun.shi
 */
//@WebListener
public class CustomizeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}
