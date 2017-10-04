package br.com.ricardosander.meupetshop.servlets.pets;

import br.com.ricardosander.meupetshop.dao.PetDAO;
import br.com.ricardosander.meupetshop.dao.PetDAOProvider;
import br.com.ricardosander.meupetshop.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/pets/edit")
public class PetEdit extends HttpServlet {

    private boolean isParametersValid(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Ops, não foi possível encontrar o pet selecionado!");

            resp.sendRedirect("/pets");
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

        int petId = Integer.parseInt(req.getParameter("id"));
        Pet pet = (Pet) req.getAttribute("pet");
        if (pet == null || pet.getId() != petId) {
            pet = new PetDAOProvider().newPetDAO().find(user, petId);
        }

        if (pet == null) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Ops, não foi possível encontrar o pet selecionado!");

            resp.sendRedirect("/pets");
            return;
        }

        req.setAttribute("pet", pet);
        req.setAttribute("dateFormatter", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        req.setAttribute("M", Gender.M);
        req.setAttribute("F", Gender.F);
        req.setAttribute("sizes", PetSize.values());

        req.getRequestDispatcher("/WEB-INF/pages/pets/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Pet pet = (Pet) req.getAttribute("pet");

        PetDAO petDAO = new PetDAOProvider().newPetDAO();
        if (!petDAO.update(pet)) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message_danger", "Houve um erro ao salvar o Pet.");

            resp.sendRedirect(req.getHeader("referer"));
            return;
        }

        FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
        flashMessage.add("message_success", "As informações do pet foram atualizadas!");

        resp.sendRedirect("/pet?id=" + pet.getId());
    }
}
