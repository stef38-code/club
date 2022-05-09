package org.stephane.club.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.stephane.club.config.filter.LoggingFilter;

/**
 * Définition de la filtration
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<LoggingFilter> headerProcessFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/club/*");
        return registrationBean;
    }

}
