package br.com.ricardosander.meupetshop.servlets.owner;

import br.com.ricardosander.meupetshop.dao.OwnerDAO;
import br.com.ricardosander.meupetshop.dao.OwnerDAOProvider;
import br.com.ricardosander.meupetshop.model.*;
import br.com.ricardosander.meupetshop.util.FlashMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/owner/edit")
public class OwnerEdit extends HttpServlet {

    private boolean isParametersValid(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Ops, não foi possível encontrar o proprietário selecionado!");

            resp.sendRedirect("/owner/list");
            return false;
        }

        return true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("loggedUser");

        if (!this.isParametersValid(req, resp)) {
            return;
        }

        int ownerId = Integer.parseInt(req.getParameter("id"));
        Owner owner = (Owner) req.getAttribute("owner");
        if (owner == null || owner.getId() != ownerId) {
            owner = new OwnerDAOProvider().newOwnerDAO().find(user, ownerId);
        }

        if (owner == null) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Ops, não foi possível encontrar o proprietário selecionado!");

            resp.sendRedirect("/owner/list");
            return;
        }

        req.setAttribute("owner", owner);

        req.getRequestDispatcher("/WEB-INF/pages/owners/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Owner owner = (Owner) req.getAttribute("owner");

        OwnerDAO ownerDAO = new OwnerDAOProvider().newOwnerDAO();
        if (!ownerDAO.update(owner)) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Houve um erro ao salvar o Proprietário.");

            resp.sendRedirect(req.getHeader("referer"));
            return;
        }

        FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
        flashMessage.add("message_success", "As informações do proprietário foram atualizadas!");

        resp.sendRedirect("/owner?id=" + owner.getId());
    }
}
