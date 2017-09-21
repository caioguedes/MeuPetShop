package br.com.ricardosander.meupetshop.dao;

/**
 * Provider para PetDAO.
 */
public class PetDAOProvider {

    /**
     * @return Retorna uma instância da classe padrão.
     */
    public PetDAO newPetDAO() {
        return new MySQLPetDAO();
    }

}