package br.com.ricardosander.meupetshop.servlets.pets;

import br.com.ricardosander.meupetshop.dao.PetDAO;
import br.com.ricardosander.meupetshop.dao.PetDAOProvider;
import br.com.ricardosander.meupetshop.model.FlashMessage;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/pet/remove")
public class PetRemove extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String previouslyPage = req.getHeader("Referer");

        long id = 0;

        User user = (User) req.getSession().getAttribute("loggedUser");

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception exception) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message", "Pet não informado.");

            resp.sendRedirect("/pets");
            return;
        }

        PetDAO petDAO = new PetDAOProvider().newPetDAO();
        Pet pet = petDAO.find(user, id);

        if (pet == null) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message", "Pet não encontrado.");

            resp.sendRedirect("/pets");
            return;
        }

        req.setAttribute("pet", pet);
        req.setAttribute("previouslyPage", previouslyPage);

        req.getRequestDispatcher("/WEB-INF/pages/pets/remove.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String previouslyPage = req.getHeader("Referer");

        long id = 0;

        User user = (User) req.getSession().getAttribute("loggedUser");

        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception exception) {
            req.getSession().setAttribute("message", "Pet não informado.");
            resp.sendRedirect("/pets");
            return;
        }

        PetDAO petDAO = new PetDAOProvider().newPetDAO();
        Pet pet = petDAO.find(user, id);

        if (pet == null) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message", "Pet não encontrado.");

            resp.sendRedirect("/pets");
            return;
        }

        if (!petDAO.remove(pet)) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message", "Não foi possível remover o pet.");

            resp.sendRedirect(previouslyPage);
            return;
        }

        FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
        flashMessage.add("message", "Pet removido com sucesso.");

        resp.sendRedirect("/pets");
    }

}
