package br.com.ricardosander.meupetshop.http;

import br.com.ricardosander.meupetshop.http.get.Index;
import br.com.ricardosander.meupetshop.http.get.NotFound;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe responsável por criar HttpHandlers.
 */
public class HttpHandlerFactory {

    /**
     * Cria um HttpHandler com base na requisição.
     * @param request Requisição a ser processada.
     * @return Handler para a requisição.
     */
    public synchronized HttpHandler newHttpHandler(HttpServletRequest request) {

        String requestURI = request.getRequestURI();
        String[] requestUriParts = requestURI.split("/");
        if (requestUriParts.length < 2) {
            return new Index();
        }

        String resource = requestUriParts[1].substring(0, 1).toUpperCase() + requestUriParts[1].substring(1).toLowerCase();
        String className = "br.com.ricardosander.meupetshop.http." + request.getMethod().toLowerCase() + "." + resource;

        try {

            Class<?> handler = Class.forName(className);

            return (HttpHandler) handler.newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return new NotFound();
        }

    }

}