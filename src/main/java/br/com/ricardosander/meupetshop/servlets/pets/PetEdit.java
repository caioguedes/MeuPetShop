package br.com.ricardosander.meupetshop.servlets.pets;

import br.com.ricardosander.meupetshop.dao.PetDAO;
import br.com.ricardosander.meupetshop.dao.PetDAOProvider;
import br.com.ricardosander.meupetshop.model.*;
import br.com.ricardosander.meupetshop.validator.PetValidator;
import br.com.ricardosander.meupetshop.validator.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet (urlPatterns = "/pets/edit")
public class PetEdit extends HttpServlet {

    private boolean isParametersValid(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
            req.getSession().setAttribute("message", "Ops, não foi possível encontrar o pet selecionado!");
            resp.sendRedirect("/pets");
            return false;
        }

        return true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("loggedUser");
        Pet pet = null;

        if (!this.isParametersValid(req, resp)) {
            return;
        }

        int petId = Integer.parseInt(req.getParameter("id"));
        if (req.getSession().getAttribute("pet") != null) {
            pet = (Pet) req.getSession().getAttribute("pet");
            req.getSession().removeAttribute("pet");
        } else {
            pet = new PetDAOProvider().newPetDAO().find(user, petId);
        }

        if (pet == null) {
            req.getSession().setAttribute("message", "Ops, não foi possível encontrar o pet selecionado!");
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

        Map<String, Object> errors = new HashMap<>();

        if (!this.isParametersValid(req, resp)) {
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String species = req.getParameter("species");
        String breed = req.getParameter("breed");
        String fur = req.getParameter("fur");
        String pelage = req.getParameter("pelage");

        PetSize size;
        try {
            size = PetSize.valueOf(req.getParameter("size"));
        } catch (Exception exception) {
            size = null;
        }

        String weightString = req.getParameter("weight");
        String comments = req.getParameter("comments");

        Gender gender;
        try {
            gender = Gender.valueOf(req.getParameter("gender"));
        } catch (Exception exception) {
            gender = null;
        }

        String registerString = req.getParameter("register");
        String birthString = req.getParameter("birth");
        String castratedString = req.getParameter("castrated");
        String clientPacketString = req.getParameter("clientPacket");
        String ownerIdString = req.getParameter("owner_id");

        double weight = 0.0;
        try {
            weight = Double.parseDouble(weightString.replace(",", "."));
        } catch (Exception exception) {
            errors.put("pet_weight", "O campo Peso deve ser um valor numérico válido.");
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate register = null;
        try {

            if (registerString != null && !registerString.trim().isEmpty()) {
                register = LocalDate.parse(registerString, dateTimeFormatter);
            }

        } catch (Exception exception) {
            errors.put("pet_register", "O campo Cadastro é de preenchimento obrigatório.");
        }

        LocalDate birth = null;
        try {

            if (birthString != null && !birthString.trim().isEmpty()) {
                birth = LocalDate.parse(birthString, dateTimeFormatter);
            }

        } catch (Exception exception) {
            errors.put("pet_birth", "O campo Nascimento informado é inválido.");
        }

        boolean castrated = castratedString != null;

        boolean clientPacket = clientPacketString != null;

        long ownerId = 0;
        Owner owner;
        if (ownerIdString != null && !ownerIdString.trim().isEmpty()) {

            try {
                ownerId = Integer.parseInt(ownerIdString.trim());
            } catch (Exception exception) {
                //TODO tratar.
            }
            //TODO buscar owner.
        }

        User user = (User) req.getSession().getAttribute("loggedUser");

        Pet pet = new Pet(
                name,
                species,
                breed,
                fur,
                pelage,
                size,
                weight,
                birth,
                register,
                castrated,
                comments,
                gender,
                clientPacket,
                user
        );
        pet.setId(id);

        Validator validator = new PetValidator();
        errors.putAll(validator.validate(pet));

        if (!errors.isEmpty()) {

            errors.put("pet", pet);
            errors.forEach(req.getSession()::setAttribute);

            resp.sendRedirect("/pets/edit?id=" + id);
            return;
        }

        PetDAO petDAO = new PetDAOProvider().newPetDAO();
        if (!petDAO.update(pet)) {
            req.getSession().setAttribute("message", "Houve um erro ao salvar o Pet.");
            resp.sendRedirect("/pets/edit?id=" + id);
            return;
        }

        req.getSession().setAttribute("message", "As informações do pet foram atualizadas!");
        resp.sendRedirect("/pet?id=" + pet.getId());
    }
}
