package com.example.config;

import com.example.filter.ParamsFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 过滤器配置类
 * @author chengdongyi
 * @date 2019/7/1 10:31
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean parmsFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new ParamsFilter());
        registration.addUrlPatterns("/*");

        // 排除不需要过滤的请求
        Set<String> set = new HashSet<>();
        set.add("/hello");
        set.add("/testFilter");
        String urls = StringUtils.join(set.toArray(), ",");
        registration.addInitParameter("exclusions", urls);
        registration.setName("ParamsFilter");
        registration.setOrder(Integer.MAX_VALUE - 1);
        return registration;
    }

}
