package br.com.ricardosander.meupetshop.validator;

import br.com.ricardosander.meupetshop.model.Phone;

import java.util.HashMap;
import java.util.Map;

/**
 * Realiza validação de um telefone.
 */
public class PhoneValidator implements Validator<Phone> {

    @Override
    public Map<String, String> validate(Phone phone) {

        boolean isDDDEmpty = false;
        boolean isNumberEmpty = false;

        Map<String, String> errors = new HashMap<>();

        if (phone == null) {
            return errors;
        }

        if (phone.getDdd() == null || phone.getDdd().trim().isEmpty()) {
            errors.put("phone", "O campo DDD é de preenchimento obrigatório.");
            isDDDEmpty = true;
        }

        if (phone.getNumber() == null || phone.getNumber().trim().isEmpty()) {
            errors.put("phone", "O campo Telefone é de preenchimento obrigatório.");
            isNumberEmpty = true;
        }

        if (isDDDEmpty && isNumberEmpty) {
            return errors;
        }

        if (!isDDDEmpty && !phone.getDdd().matches("[0-9]+")) {
            errors.put("phone", "O campo DDD deve conter apenas valores numéricos.");
        }

        if (!isNumberEmpty && !phone.getNumber().matches("[0-9]+")) {
            errors.put("phone", "O campo Telefone deve conter apenas valores numéricos.");
        }

        if (!isDDDEmpty && phone.getDdd().trim().length() != 2) {
            errors.put("phone", "O campo DDD deve conter exatamente 2 caracteres.");
        }

        if (!isNumberEmpty && phone.getNumber().trim().length() != 9) {
            errors.put("phone", "O campo Telefone deve conter exatamente 9 caracteres.");
        }

        return errors;
    }

}
