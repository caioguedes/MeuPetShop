package br.com.ricardosander.meupetshop.servlets;

import br.com.ricardosander.meupetshop.dao.UserDAO;
import br.com.ricardosander.meupetshop.dao.UserDAOProvider;
import br.com.ricardosander.meupetshop.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Página de login.
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");

        UserDAO userDAO = new UserDAOProvider().newUserDAO();
        User user = userDAO.find(usuario, senha);

        if (user != null) {
            req.getSession().setAttribute("loggedUser", user);
        }

        resp.sendRedirect("/");
    }
}