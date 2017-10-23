package br.com.ricardosander.meupetshop.servlets.owner;

import br.com.ricardosander.meupetshop.dao.OwnerDAO;
import br.com.ricardosander.meupetshop.dao.OwnerDAOProvider;
import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.User;
import br.com.ricardosander.meupetshop.util.FlashMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/owner")
public class OwnerView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = 0;

        User user = (User) req.getSession().getAttribute("loggedUser");

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception exception) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Proprietário não informado.");

            resp.sendRedirect("/owner/list");
            return;
        }

        OwnerDAO ownerDAO = new OwnerDAOProvider().newOwnerDAO();
        Owner owner = ownerDAO.find(user, id);

        if (owner == null) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Proprietário não encontrado.");

            resp.sendRedirect("/owner/list");
            return;
        }

        req.setAttribute("owner", owner);

        req.getRequestDispatcher("/WEB-INF/pages/owners/view.jsp").forward(req, resp);
    }
}
