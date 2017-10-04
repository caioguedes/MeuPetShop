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

@WebServlet(urlPatterns = "/pets/register")
public class PetRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("dateFormatter", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        req.setAttribute("M", Gender.M);
        req.setAttribute("F", Gender.F);
        req.setAttribute("sizes", PetSize.values());

        req.getRequestDispatcher("/WEB-INF/pages/pets/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Pet pet = (Pet) req.getAttribute("pet");

        PetDAO petDAO = new PetDAOProvider().newPetDAO();
        if (!petDAO.insert(pet)) {

            FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
            flashMessage.add("message", "Houve um erro ao salvar o Pet.");

            resp.sendRedirect("/pets/register");
            return;
        }

        FlashMessage flashMessage = (FlashMessage) req.getSession().getAttribute("flash_message");
        flashMessage.add("message", "Pet adicionado com sucesso.");

        resp.sendRedirect("/pet?id=" + pet.getId());
    }

}