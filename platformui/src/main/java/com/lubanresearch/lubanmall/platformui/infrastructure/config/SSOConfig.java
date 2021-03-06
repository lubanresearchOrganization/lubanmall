package com.lubanresearch.lubanmall.platformui.infrastructure.config;

import com.lubanresearch.lubanmall.ssoclient.filter.SSOFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
/**
 * Created by hilbertcao on 2017/12/2.
 */
//@Configuration
public class SSOConfig {
    @Value("${sso.ssoServerLoginUrl}")
    private String ssoServerLoginUrl;
    @Value("${sso.checktiketUrl}")
    private String checkTicketUrl;

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        SSOFilter ssoFilter = new SSOFilter(ssoServerLoginUrl,checkTicketUrl);
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(ssoFilter);
        registration.addUrlPatterns("/*");
        registration.setName("ssoFilter");
        registration.setOrder(1);
        return registration;
    }



}
