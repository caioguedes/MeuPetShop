package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import java.util.List;

public interface PetDAO {

    /**
     * Busca os pets do usuário.
     * @param user Usuário do cadastro do pet.
     * @return Lista de pets do usuário.
     */
    List<Pet> find(User user);

    /**
     * Insere um novo pet.
     * @param pet Novo Pet para cadastro.
     * @return Se houve sucesso no cadastro.
     */
    boolean insert(Pet pet);

}