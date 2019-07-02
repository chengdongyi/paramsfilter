package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chengdongyi
 * @description: 请求参数过滤器
 * @date 2019/7/1 10:33
 */
public class ParamsFilter implements Filter {

    public static final String PARAM_NAME_EXCLUSIONS = "exclusions";
    public static final String SEPARATOR = ",";
    private Set<String> excludesUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String param = filterConfig.getInitParameter(PARAM_NAME_EXCLUSIONS);
        if (param != null && param.trim().length() != 0) {
            this.excludesUrls = new HashSet(Arrays.asList(param.split(SEPARATOR)));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String requestURI = httpRequest.getRequestURI();

        if (this.isExclusion(requestURI)) {
            // 不过滤
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 过滤
            ParamsRequestWrapper requestWrapper = new ParamsRequestWrapper(httpRequest);
            filterChain.doFilter(requestWrapper, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    public boolean isExclusion(String requestURI) {

        if (this.excludesUrls == null) {
            return false;
        }

        for (String url : this.excludesUrls) {
            if (url.equals(requestURI)) {
                return true;
            }
        }
        return false;
    }

}
