package springmybatis.custom;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

////Configuration相当于把该类作为spring的xml配置文件中的<beans>
//@WebFilter注解将一个实现了javax.servlet.Filter接口的类定义为过滤器

//@Configuration

//不用此过滤器，用spring security
//@WebFilter(filterName="CustomFilter",urlPatterns="/*")
public class CustomFilter implements Filter  {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("初始化过滤器11");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String servletPath = httpRequest.getServletPath();
        Object user = httpRequest.getSession().getAttribute("username");
        if(servletPath.contains("login")||
           servletPath.contains("css")||
           servletPath.contains("js")||
           servletPath.contains("img")
           )
        {
            //System.out.println("放走登陆路径");
            filterChain.doFilter(httpRequest, httpResponse);
        }
        else
        {
            if ((user == null)) {
                String Httppath=httpRequest.getContextPath();
                System.err.println(Httppath);
                httpResponse.sendRedirect(Httppath + "/login.html");
                return;
            }
            //System.out.println("执行过滤器");

            filterChain.doFilter(httpRequest, httpResponse);
        }
        //filterChain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }

    /**
     * 配置过滤器
     * @return
     */
   /* @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        return registration;
    }

    *//**
     * 创建一个bean
     * @return
     *//*
    @Bean(name = "CustomFilter")
    public Filter sessionFilter() {
        return new CustomFilter();
    }*/
}
