package br.com.ricardosander.meupetshop.controller;

import br.com.ricardosander.meupetshop.http.HttpHandlerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class FrontController extends HttpServlet {

    /**
     * Fábrica de handlers para as requisições http.
     */
    private final HttpHandlerFactory httpHandlerFactory;

    public FrontController() {
        this.httpHandlerFactory = new HttpHandlerFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String destino = this.httpHandlerFactory.newHttpHandler(req).handler(req, resp);

        req.getRequestDispatcher(destino).forward(req, resp);
    }

}