package br.com.ricardosander.meupetshop.http.get;

import br.com.ricardosander.meupetshop.http.HttpHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe para páginas não encontradas.
 */
public class NotFound implements HttpHandler {

    @Override
    public String handler(HttpServletRequest req, HttpServletResponse resp) {

        resp.setStatus (404);

        return "WEB-INF/pages/404.jsp";
    }

}