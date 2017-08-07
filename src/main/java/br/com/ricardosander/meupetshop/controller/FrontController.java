package br.com.ricardosander.meupetshop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class FrontController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tarefa = "br.com.ricardosander.meupetshop.http." + req.getMethod().toLowerCase() + "";

        this.getAction(req);

        String destino = "WEB-INF/pages/404.jsp";
        req.getRequestDispatcher(destino).forward(req, resp);
    }

    private void getAction(HttpServletRequest request) {

        String[] resources = request.getRequestURI().split("/");

        if (resources.length < 2) {
            return;//TODO retornar index.
        }

        String method = request.getMethod().toLowerCase();
        String pacote = "br.com.ricardosander.meupetshop." + method + "." + resources[1].substring(0, 1).toUpperCase() + resources[1].substring(1);

        System.out.println(pacote);
    }

}