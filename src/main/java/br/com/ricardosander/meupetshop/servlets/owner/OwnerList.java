package br.com.ricardosander.meupetshop.servlets.owner;

import br.com.ricardosander.meupetshop.criteria.Criteria;
import br.com.ricardosander.meupetshop.criteria.CriteriaBuilder;
import br.com.ricardosander.meupetshop.dao.OwnerDAO;
import br.com.ricardosander.meupetshop.dao.OwnerDAOProvider;
import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.User;
import br.com.ricardosander.meupetshop.util.Paginator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/owner/list")
public class OwnerList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int page;
        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (Exception exception) {
            page = 1;
        }

        User loggedUser = (User) req.getSession().getAttribute("loggedUser");
        String searchName = req.getParameter("searchName");

        CriteriaBuilder criteriaBuilder = new CriteriaBuilder();

        if (searchName != null) {
            criteriaBuilder.name(searchName);
            req.setAttribute("searchName", searchName);
        }

        OwnerDAO ownerDAO = new OwnerDAOProvider().newOwnerDAO();
        int totalRegister = ownerDAO.count(loggedUser, criteriaBuilder.build());

        Paginator paginator = new Paginator(page, totalRegister);

        criteriaBuilder.
                limit(paginator.getRegistersPerPage())
                .offset(paginator.getOffSet());

        List<Owner> owners = ownerDAO.find(loggedUser, criteriaBuilder.build());

        req.setAttribute("owners", owners);
        req.setAttribute("paginator", paginator);

        req.getRequestDispatcher("/WEB-INF/pages/owners/list.jsp").forward(req, resp);
    }

}
