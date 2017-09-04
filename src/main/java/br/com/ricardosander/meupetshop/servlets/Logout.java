package br.com.ricardosander.meupetshop.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet para realização de logout.
 */
@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("loggedUser") == null) {
            resp.sendRedirect("/login");
            return;
        }

        req.getSession().removeAttribute("loggedUser");
        req.getRequestDispatcher("/WEB-INF/pages/logout.jsp").forward(req, resp);
    }

}