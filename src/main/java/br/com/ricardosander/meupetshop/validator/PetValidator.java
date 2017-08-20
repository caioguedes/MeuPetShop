package br.com.ricardosander.meupetshop.validator;

import br.com.ricardosander.meupetshop.model.Pet;

import java.io.InvalidObjectException;
import java.util.LinkedList;
import java.util.List;

/**
 * validador de cadastro de Pet.
 */
public class PetValidator implements Validator {

    /**
     * Pet para validação.
     */
    private final Pet pet;

    /**
     * Lista de erros.
     */
    private final List<String> errors;

    /**
     * @param pet Pet para validação.
     */
    public PetValidator(Pet pet) {
        this.pet = pet;
        this.errors = new LinkedList<>();
    }

    @Override
    public void validate() throws InvalidObjectException {


        if (this.pet.getName() == null || this.pet.getName().trim().isEmpty()) {
            this.errors.add("O campo Nome do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getSpecies() == null || this.pet.getSpecies().trim().isEmpty()) {
            this.errors.add("O campo Espécie do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getBreed() == null || this.pet.getBreed().trim().isEmpty()) {
            this.errors.add("O campo Raça do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getFur() == null || this.pet.getFur().trim().isEmpty()) {
            this.errors.add("O campo Pêlo do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getPelage() == null || this.pet.getPelage().trim().isEmpty()) {
            this.errors.add("O campo Pelagem do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getMien() == null || this.pet.getMien().trim().isEmpty()) {
            this.errors.add("O campo Porte do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getWeight() == 0.0) {
            this.errors.add("O campo Peso do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getBirth() == null) {
            this.errors.add("O campo Nascimento do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getRegister() == null) {
            this.errors.add("O campo Cadastro do pet é de preenchimento obrigatório.");
        }

        if (this.pet.getGender() == null || this.pet.getGender().trim().isEmpty()) {
            this.errors.add("O campo Nome do pet é de preenchimento obrigatório.");
        }

        if (this.errors.size() > 0) {
            throw new InvalidObjectException("Objeto inválido.");
        }

    }

    @Override
    public List<String> getErrors() {
        return this.errors;
    }

}