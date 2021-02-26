package com.tx.boot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
@Component
public class Controller implements ServletContextAware {

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("setServletContext方法");
    }
}
