package com.spring.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AjaxFilter implements javax.servlet.Filter {

    private List<String> filterList =new ArrayList();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String ajaxFilter = PropertyUtils.getProperty("ajaxFilter");
        if(ajaxFilter!=null && !"".equals(ajaxFilter)){
            String[] split = ajaxFilter.split(";");
            for(String filter:split){
                filterList.add(filter);
            }
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        String curOrigin = httpServletRequest.getHeader("Origin");
        System.out.println("doFilter"+curOrigin);
        if(filterList.contains(curOrigin)){
            httpServletResponse.setHeader("Access-Control-Allow-Origin", curOrigin);
        }
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authentication");
        filterChain.doFilter(servletRequest,httpServletResponse);
    }

    @Override
    public void destroy() {
        filterList.clear();
    }
}