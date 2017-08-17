package br.com.ricardosander.meupetshop.servlets.pets;

import br.com.ricardosander.meupetshop.model.Client;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PetList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Pet> pets = new LinkedList<>();
        pets.add(new Pet(
                1,
                "Piccolo",
                "Gato",
                "SRD",
                "Branco e Preto",
                "Longa",
                "Grande",
                12.4,
                LocalDate.of(2014, 11, 20),
                LocalDate.of(2015, 1, 10),
                true,
                "Meu gato amado",
                "Macho",
                false,
                (User) req.getSession().getAttribute("loggedUser"),
                new Client(1, "Ricardo Sander Lopes")
        ));

        pets.add(new Pet(
                2,
                "Loki",
                "Cão",
                "Pincher",
                "Marrom",
                "Curto",
                "Pequeno",
                3.4,
                LocalDate.of(2010, 5, 2),
                LocalDate.of(2015, 10, 1),
                false,
                null,
                "Macho",
                false,
                (User) req.getSession().getAttribute("loggedUser"),
                new Client(2, "Scarlet Nedel")
        ));

        req.setAttribute("pets", pets);

        req.getRequestDispatcher("/WEB-INF/pages/pets/list.jsp").forward(req, resp);
    }
}
