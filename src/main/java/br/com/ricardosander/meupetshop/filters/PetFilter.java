package br.com.ricardosander.meupetshop.filters;

import br.com.ricardosander.meupetshop.model.*;
import br.com.ricardosander.meupetshop.util.FlashMessage;
import br.com.ricardosander.meupetshop.validator.PetValidator;
import br.com.ricardosander.meupetshop.validator.Validator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Filtro para transformar e validar uma requisição em um pet.
 */
@WebFilter(urlPatterns = {"/pets/register", "/pets/edit"})
public class PetFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (!request.getMethod().equalsIgnoreCase("POST")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Map<String, Object> errors = new HashMap<>();

        int petId = 0;
        try {
            petId = Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {

        }
        String name = request.getParameter("name");
        String species = request.getParameter("species");
        String breed = request.getParameter("breed");
        String fur = request.getParameter("fur");
        String pelage = request.getParameter("pelage");

        PetSize size;
        try {
            size = PetSize.valueOf(request.getParameter("size"));
        } catch (Exception exception) {
            size = null;
        }

        String weightString = request.getParameter("weight");
        String comments = request.getParameter("comments");

        Gender gender;
        try {
            gender = Gender.valueOf(request.getParameter("gender"));
        } catch (Exception exception) {
            gender = null;
        }

        String registerString = request.getParameter("register");
        String birthString = request.getParameter("birth");
        String castratedString = request.getParameter("castrated");
        String clientPacketString = request.getParameter("clientPacket");
        String ownerIdString = request.getParameter("owner_id");

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

        User user = (User) request.getSession().getAttribute("loggedUser");

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
        pet.setId(petId);

        Validator validator = new PetValidator();
        errors.putAll(validator.validate(pet));

        if (!errors.isEmpty()) {

            errors.put("pet", pet);
            FlashMessage flashMessage = (FlashMessage) request.getSession().getAttribute("flash_message");
            if (flashMessage == null) {
                flashMessage = new FlashMessage();
                request.getSession().setAttribute("flash_message", flashMessage);
            }

            for (Map.Entry entry : errors.entrySet()) {
                flashMessage.add(entry.getKey().toString(), entry.getValue());
            }

            response.sendRedirect(request.getHeader("referer"));
            return;
        }

        servletRequest.setAttribute("pet", pet);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
