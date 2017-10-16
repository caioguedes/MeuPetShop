package br.com.ricardosander.meupetshop.dao;

/**
 * Provider para OwnerDAO.
 */
public class OwnerDAOProvider {

    /**
     * @return Retorna uma instância da classe padrão.
     */
    public OwnerDAO newOwnerDAO() {
        return new MySQLOwnerDAO();
    }

}
