package com.works.configs;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        String[] freeUrls = {"/", "/login"};
        boolean sessionStatus = true;
        for ( String item : freeUrls ) {
            if (item.equals(url)) {
                sessionStatus = false;
                break;
            }
        }

        if ( sessionStatus ) {
            boolean loginStatus = req.getSession().getAttribute("admin") == null;
            if (loginStatus) {
                // session fail
                res.sendRedirect("/");
            }else {
                String email = (String) req.getSession().getAttribute("admin");
                req.setAttribute("email", email);
                filterChain.doFilter(req, res);
            }
        }else {
            filterChain.doFilter(req, res);
        }



    }

}
