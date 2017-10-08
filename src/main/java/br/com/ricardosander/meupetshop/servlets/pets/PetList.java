package br.com.ricardosander.meupetshop.servlets.pets;

import br.com.ricardosander.meupetshop.criteria.PetCriteriaBuilder;
import br.com.ricardosander.meupetshop.dao.MySQLPetDAO;
import br.com.ricardosander.meupetshop.dao.PetDAO;
import br.com.ricardosander.meupetshop.dao.PetDAOProvider;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;
import br.com.ricardosander.meupetshop.util.Paginator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/pets")
public class PetList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User loggedUser = (User) req.getSession().getAttribute("loggedUser");
        String searchName = req.getParameter("searchName");

        int page;
        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (Exception exception) {
            page = 1;
        }

        PetCriteriaBuilder petCriteriaBuilder = new PetCriteriaBuilder();
        if (searchName != null) {
            petCriteriaBuilder.name(searchName);
            req.setAttribute("searchName", searchName);
        }

        PetDAO petDAO = new PetDAOProvider().newPetDAO();
        int totalRegister = petDAO.count(loggedUser, petCriteriaBuilder.build());

        Paginator paginator = new Paginator(page, totalRegister);

        petCriteriaBuilder
                .limit(paginator.getRegistersPerPage())
                .offset(paginator.getOffSet());

        List<Pet> pets = new MySQLPetDAO().find(loggedUser, petCriteriaBuilder.build());

        req.setAttribute("pets", pets);
        req.setAttribute("paginator", paginator);

        req.getRequestDispatcher("/WEB-INF/pages/pets/list.jsp").forward(req, resp);
    }
}
