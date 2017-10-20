package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.criteria.Criteria;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import java.util.List;

public interface PetDAO {

    /**
     * Conta a quantidade total de registro para o filtro informado.
     *
     * @param user        Usuário do cadastro do pet.
     * @param criteria Critéro de busca.
     * @return Total de resultados.
     */
    int count(User user, Criteria criteria);

    /**
     * Busca os pets do usuário.
     *
     * @param user        Usuário do cadastro do pet.
     * @param criteria Critério de busca.
     * @return Lista de pets do usuário.
     */
    List<Pet> find(User user, Criteria criteria);

    /**
     * Busca um pet pelo seu identificador.
     *
     * @param id Identificador do pet.
     * @return Pet encontrado para o identificador, ou <code>NULL</code> caso o pet não seja encontrado.
     */
    Pet find(User user, long id);

    /**
     * Insere um novo pet.
     *
     * @param pet Novo Pet para cadastro.
     * @return Se houve sucesso no cadastro.
     */
    boolean insert(Pet pet);

    /**
     * Remove um pet.
     *
     * @param pet Pet para remoção.
     * @return Se houve sucesso na remoção.
     */
    boolean remove(Pet pet);

    /**
     * Atualiza um pet.
     *
     * @param pet
     * @return boolean
     */
    boolean update(Pet pet);
}