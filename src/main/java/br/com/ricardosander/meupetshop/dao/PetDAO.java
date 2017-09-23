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
     * Busca um pet pelo seu identificador.
     * @param id Identificador do pet.
     * @return Pet encontrado para o identificador, ou <code>NULL</code> caso o pet não seja encontrado.
     */
    Pet find(User user, long id);

    /**
     * Insere um novo pet.
     * @param pet Novo Pet para cadastro.
     * @return Se houve sucesso no cadastro.
     */
    boolean insert(Pet pet);

}