package br.com.ricardosander.meupetshop.validator;

import br.com.ricardosander.meupetshop.model.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * validador de cadastro de Pet.
 */
public class PetValidator implements Validator<Pet> {

    @Override
    public Map<String, String> validate(Pet pet) {

        Map<String, String> errors = new HashMap<>();

        if (pet.getName() == null || pet.getName().trim().isEmpty()) {
            errors.put("pet_name", "O campo Nome do pet é de preenchimento obrigatório.");
        }

        if (pet.getSpecies() == null || pet.getSpecies().trim().isEmpty()) {
            errors.put("pet_species", "O campo Espécie do pet é de preenchimento obrigatório.");
        }

        if (pet.getBreed() == null || pet.getBreed().trim().isEmpty()) {
            errors.put("pet_breed", "O campo Raça do pet é de preenchimento obrigatório.");
        }

        if (pet.getFur() == null || pet.getFur().trim().isEmpty()) {
            errors.put("pet_fur", "O campo Pêlo do pet é de preenchimento obrigatório.");
        }

        if (pet.getPelage() == null || pet.getPelage().trim().isEmpty()) {
            errors.put("pet_pelage", "O campo Pelagem do pet é de preenchimento obrigatório.");
        }

        if (pet.getSize() == null || pet.getSize().trim().isEmpty()) {
            errors.put("pet_size", "O campo Porte do pet é de preenchimento obrigatório.");
        }

        if (pet.getWeight() == 0.0) {
            errors.put("pet_weight", "O campo Peso do pet é de preenchimento obrigatório.");
        }

        if (pet.getBirth() == null) {
            errors.put("pet_birth", "O campo Nascimento do pet é de preenchimento obrigatório.");
        }

        if (pet.getRegister() == null) {
            errors.put("pet_register", "O campo Cadastro do pet é de preenchimento obrigatório.");
        }

        if (pet.getGender() == null) {
            errors.put("pet_gender", "O campo Sexo do pet é de preenchimento obrigatório.");
        }

        return errors;
    }

}