package br.com.ricardosander.meupetshop.servlets.pets;

import br.com.ricardosander.meupetshop.dao.PetDAO;
import br.com.ricardosander.meupetshop.dao.PetDAOProvider;
import br.com.ricardosander.meupetshop.util.FlashMessage;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/pet")
public class PetView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = 0;

        User user = (User) req.getSession().getAttribute("loggedUser");

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception exception) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Pet não informado.");

            resp.sendRedirect("/pets");
            return;
        }

        PetDAO petDAO = new PetDAOProvider().newPetDAO();
        Pet pet = petDAO.find(user, id);

        if (pet == null) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Pet não encontrado.");

            resp.sendRedirect("/pets");
            return;
        }

        req.setAttribute("dateFormatter", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        req.setAttribute("pet", pet);

        req.getRequestDispatcher("/WEB-INF/pages/pets/view.jsp").forward(req, resp);
    }

}
