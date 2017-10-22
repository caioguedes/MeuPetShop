package br.com.ricardosander.meupetshop.filters;

import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.Phone;
import br.com.ricardosander.meupetshop.model.User;
import br.com.ricardosander.meupetshop.util.FlashMessage;
import br.com.ricardosander.meupetshop.validator.OwnerValidator;
import br.com.ricardosander.meupetshop.validator.Validator;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = {"/owner/register", "/owner/edit"})
public class OwnerFilter implements Filter {

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

        String name = request.getParameter("name");
        String secondaryName = request.getParameter("secondary_name");
        String address = request.getParameter("address");
        String district = request.getParameter("district");

        List<Phone> phones = new ArrayList<>();

        phones.add(new Phone(request.getParameter("ddd"), request.getParameter("phone")));
        phones.add(new Phone(request.getParameter("ddd2"), request.getParameter("phone2")));
        phones.add(new Phone(request.getParameter("ddd3"), request.getParameter("phone3")));
        phones.add(new Phone(request.getParameter("ddd4"), request.getParameter("phone4")));
        phones.add(new Phone(request.getParameter("ddd5"), request.getParameter("phone5")));

        for (int index = 1; index < phones.size(); index++) {

            if ((phones.get(index).getDdd() == null || phones.get(index).getDdd().trim().isEmpty())
                    && (phones.get(index).getNumber() == null || phones.get(index).getNumber().trim().isEmpty())) {
                phones.set(index, null);
            }
        }

        String comments = request.getParameter("comments");
        double debtor = 0.0;

        try {

            String stringDebtor = request.getParameter("debtor");
            if (stringDebtor != null && !stringDebtor.trim().isEmpty()) {
                debtor = Double.parseDouble(stringDebtor.replace(",", "."));
            }
        } catch (Exception e) {
            errors.put("owner_debtor", "O campo Valor Devedor deve ser um valor numérico válido ou vazio.");
        }

        User user = (User) request.getSession().getAttribute("loggedUser");

        Owner owner = new Owner();
        owner.setName(name);
        owner.setSecondaryName(secondaryName);
        owner.setAddress(address);
        owner.setDistrict(district);
        owner.setPhone(phones.get(0));
        owner.setPhone2(phones.get(1));
        owner.setPhone3(phones.get(2));
        owner.setPhone4(phones.get(3));
        owner.setPhone5(phones.get(4));
        owner.setComments(comments);
        owner.setDebtor(debtor);
        owner.setUser(user);

        Validator validator = new OwnerValidator();
        errors.putAll(validator.validate(owner));

        if (!errors.isEmpty()) {

            errors.put("owner", owner);
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

        servletRequest.setAttribute("owner", owner);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
