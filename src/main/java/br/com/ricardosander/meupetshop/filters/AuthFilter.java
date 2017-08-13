package br.com.ricardosander.meupetshop.filters;

import br.com.ricardosander.meupetshop.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String requestURI = httpServletRequest.getRequestURI();
        if (requestURI.equals("/login") || requestURI.matches(".*(css|jpg|png|gif|js)")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        User loggedUser = (User) httpServletRequest.getSession().getAttribute("loggedUser");

        if (loggedUser == null) {

            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}