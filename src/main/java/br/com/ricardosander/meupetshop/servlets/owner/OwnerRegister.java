package br.com.ricardosander.meupetshop.servlets.owner;

import br.com.ricardosander.meupetshop.dao.OwnerDAO;
import br.com.ricardosander.meupetshop.dao.OwnerDAOProvider;
import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.util.FlashMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/owner/register")
public class OwnerRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/pages/owners/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Owner owner = (Owner) req.getAttribute("owner");

        OwnerDAO ownerDAO = new OwnerDAOProvider().newOwnerDAO();
        if (!ownerDAO.insert(owner)) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Houve um erro ao salvar o proprietário.");

            resp.sendRedirect("/owner/register");
            return;
        }

        FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
        flashMessage.add("message_success", "Proprietário adicionado com sucesso.");

        resp.sendRedirect("/owner?id=" + owner.getId());
    }

}
