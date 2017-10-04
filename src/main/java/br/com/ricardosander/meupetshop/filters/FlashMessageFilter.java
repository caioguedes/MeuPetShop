package br.com.ricardosander.meupetshop.filters;

import br.com.ricardosander.meupetshop.model.FlashMessage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filtro para colocar todos flash messages da requisição anterior na requisição atual.
 */
@WebFilter(urlPatterns = "/*")
public class FlashMessageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        FlashMessage flashMessage = (FlashMessage) request.getSession().getAttribute("flash_message");

        if (flashMessage == null) {
            flashMessage = new FlashMessage();
            request.setAttribute("flash_message", flashMessage);
        }

        (flashMessage.getMessages()).forEach((messageName, messageValue) -> {
            if (request.getAttribute(messageName) == null) {
                request.setAttribute(messageName, messageValue);
            }
        });

        flashMessage.clear();

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
