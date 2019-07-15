package cn.edoclub.house.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("我是日志拦截::"+ ((servletRequest.getServletContext().getContextPath())));
        log.info("我是日志拦截::"+ ((HttpServletRequest)servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("日志拦截结束：：");
    }

    @Override
    public void destroy() {

    }
}
