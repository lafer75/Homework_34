package com.example.home_work_34;

import com.example.home_work_34.configuration.AppConfig;
import com.example.home_work_34.configuration.SpringConfig;
import com.example.home_work_34.configuration.WebConfiguration;
import com.example.home_work_34.configuration.WebMvConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class, SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfiguration.class, WebMvConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}
