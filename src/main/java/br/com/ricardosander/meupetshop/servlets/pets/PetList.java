package br.com.ricardosander.meupetshop.servlets.pets;

import br.com.ricardosander.meupetshop.dao.PetDAOProvider;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PetList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User loggedUser = (User) req.getSession().getAttribute("loggedUser");
        String message = loggedUser.getFlashMessage("message");

        List<Pet> pets = new PetDAOProvider().newPetDAO().find(loggedUser);

        req.setAttribute("pets", pets);

        if (message != null && !message.trim().isEmpty()) {
            req.setAttribute("message", message);
        }

        req.getRequestDispatcher("/WEB-INF/pages/pets/list.jsp").forward(req, resp);
    }
}
