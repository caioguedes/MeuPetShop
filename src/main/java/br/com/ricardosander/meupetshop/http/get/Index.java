package br.com.ricardosander.meupetshop.http.get;

import br.com.ricardosander.meupetshop.http.HttpHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Página inicial.
 */
public class Index implements HttpHandler {

    @Override
    public String handler(HttpServletRequest req, HttpServletResponse resp) {
        return "WEB-INF/index.jsp";
    }

}