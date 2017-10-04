package br.com.ricardosander.meupetshop.servlets;

import br.com.ricardosander.meupetshop.dao.UserDAO;
import br.com.ricardosander.meupetshop.dao.UserDAOProvider;
import br.com.ricardosander.meupetshop.model.FlashMessage;
import br.com.ricardosander.meupetshop.model.User;
import br.com.ricardosander.meupetshop.util.MD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Página de login.
 */
@WebServlet(urlPatterns = "/login")
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

        try {

            MD5 md5 = new MD5();
            senha = md5.encrypt(senha);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro ao encriptar senha: ");
            e.printStackTrace();
        }

        User user = userDAO.find(usuario, senha);

        FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
        flashMessage.add("message", "Login inválido.");

        if (user != null) {
            req.getSession().setAttribute("loggedUser", user);
            flashMessage.add("message", "Login realizado com sucesso!");
        }

        resp.sendRedirect("/");
    }
}