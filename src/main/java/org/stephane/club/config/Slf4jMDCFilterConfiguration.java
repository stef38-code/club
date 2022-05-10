package org.stephane.club.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.stephane.club.config.filter.Slf4jMDCFilter;

/**
 * Définition de la filtration
 */
/*@Configuration
@ConfigurationProperties(prefix = "club.slf4jfilter")*/
public class Slf4jMDCFilterConfiguration implements WebMvcConfigurer {

    public static final String DEFAULT_RESPONSE_TOKEN_HEADER = "Response_Token";
    public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMDCFilter.UUID";
    public static final String DEFAULT_MDC_CLIENT_IP_KEY = "Slf4jMDCFilter.ClientIP";

    private String responseHeader = DEFAULT_RESPONSE_TOKEN_HEADER;
    private String mdcTokenKey = DEFAULT_MDC_UUID_TOKEN_KEY;
    private String mdcClientIpKey = DEFAULT_MDC_CLIENT_IP_KEY;
    private String requestHeader = null;

    @Bean
    public FilterRegistrationBean<Slf4jMDCFilter> headerProcessFilter() {
        FilterRegistrationBean<Slf4jMDCFilter> registrationBean
                = new FilterRegistrationBean<>();
        Slf4jMDCFilter slf4jMDCFilter = new Slf4jMDCFilter(responseHeader, mdcTokenKey, mdcClientIpKey, requestHeader);
        registrationBean.setFilter(slf4jMDCFilter);
        /*registrationBean.addUrlPatterns("/club/*");*/
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
