package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.criteria.PetCriteria;
import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.User;

import java.util.List;

public interface OwnerDAO {

    /**
     * Conta a quantidade total de registro para o filtro informado.
     *
     * @param user        Usuário do cadastro do proprietário.
     * @param petCriteria Critéro de busca.
     * @return Total de resultados.
     */
    int count(User user, PetCriteria petCriteria);

    /**
     * Busca os proprietário do usuário.
     *
     * @param user        Usuário do cadastro do proprietário.
     * @param petCriteria Critério de busca.
     * @return Lista de proprietários do usuário.
     */
    List<Owner> find(User user, PetCriteria petCriteria);

    /**
     * Busca um proprietário pelo seu identificador.
     *
     * @param id Identificador do proprietário.
     * @return Proprietário encontrado para o identificador, ou <code>NULL</code> caso o roprietário não seja encontrado.
     */
    Owner find(User user, long id);

    /**
     * Insere um novo proprietário.
     *
     * @param owner Novo proprietário para cadastro.
     * @return Se houve sucesso no cadastro.
     */
    boolean insert(Owner owner);

    /**
     * Remove um proprietário.
     *
     * @param owner Proprietário para remoção.
     * @return Se houve sucesso na remoção.
     */
    boolean remove(Owner owner);

    /**
     * Atualiza um proprietário.
     *
     * @param owner Proprietário.
     * @return boolean
     */
    boolean update(Owner owner);

}
