package org.hfut.filter;

import org.hfut.tool.global.SystemContent;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SystemContentFilter
 *
 * @author WeiXin
 * @date 2019/1/13
 */
@WebFilter(filterName = "SystemContentFilter")
public class SystemContentFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException {
        SystemContent.setRequest((HttpServletRequest) req);
        SystemContent.setResponse((HttpServletResponse) resp);
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
