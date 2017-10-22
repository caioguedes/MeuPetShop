package br.com.ricardosander.meupetshop.validator;

import br.com.ricardosander.meupetshop.model.Owner;

import java.util.HashMap;
import java.util.Map;

/**
 * Validaor de objetos Owner
 */
public class OwnerValidator implements Validator<Owner> {

    @Override
    public Map<String, String> validate(Owner owner) {

        Map<String, String> errors = new HashMap<>();

        if (owner.getName() == null || owner.getName().trim().isEmpty()) {
            errors.put("owner_name", "O campo Nome do proprietário é de preenchimento obrigatório.");
        }

        if (owner.getSecondaryName() != null || owner.getSecondaryName().trim().isEmpty()) {
            owner.setSecondaryName(null);
        }

        if (owner.getAddress() != null || owner.getAddress().trim().isEmpty()) {
            owner.setAddress(null);
        }

        if (owner.getDistrict() == null || owner.getDistrict().trim().isEmpty()) {
            errors.put("owner_district", "O campo Bairro do proprietário é de preenchimento obrigatório.");
        }

        PhoneValidator phoneValidator = new PhoneValidator();
        if (owner.getPhone() == null) {
            errors.put("owner_phone", "O campo Telefone do proprietário é de preenchimento obrigatório.");
        } else {

            Map<String, String> phoneErros = phoneValidator.validate(owner.getPhone());
            if (!errors.isEmpty()) {

                for (Map.Entry entry : phoneErros.entrySet()) {
                    errors.put("owner_" + entry.getKey().toString(), entry.getValue().toString());
                }
            }
        }

        if (owner.getPhone2() != null) {

            Map<String, String> phoneErros = phoneValidator.validate(owner.getPhone2());
            if (!errors.isEmpty()) {

                for (Map.Entry entry : phoneErros.entrySet()) {
                    errors.put("owner_" + entry.getKey().toString() + "2", entry.getValue().toString());
                }
            }
        }

        if (owner.getPhone3() != null) {

            Map<String, String> phoneErros = phoneValidator.validate(owner.getPhone3());
            if (!errors.isEmpty()) {

                for (Map.Entry entry : phoneErros.entrySet()) {
                    errors.put("owner_" + entry.getKey().toString() + "3", entry.getValue().toString());
                }
            }
        }

        if (owner.getPhone4() != null) {

            Map<String, String> phoneErros = phoneValidator.validate(owner.getPhone4());
            if (!errors.isEmpty()) {

                for (Map.Entry entry : phoneErros.entrySet()) {
                    errors.put("owner_" + entry.getKey().toString() + "4", entry.getValue().toString());
                }
            }
        }

        if (owner.getPhone5() != null) {

            Map<String, String> phoneErros = phoneValidator.validate(owner.getPhone5());
            if (!errors.isEmpty()) {

                for (Map.Entry entry : phoneErros.entrySet()) {
                    errors.put("owner_" + entry.getKey().toString() + "5", entry.getValue().toString());
                }
            }
        }

        if (owner.getComments() != null && owner.getComments().trim().isEmpty()) {
            owner.setComments(null);
        }

        if (owner.getDebtor() < 0.0) {
            errors.put("owner_debtor", "O campo Saldo Devedor do proprietário deve ser um valor positivo ou nulo.");
        }

        return errors;
    }
}
