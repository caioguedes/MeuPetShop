package br.com.ricardosander.meupetshop.dao;

/**
 * Provider para UserDAO.
 */
public class UserDAOProvider {

    /**
     * @return Retorna uma instância da classe padrão.
     */
    public UserDAO newUserDAO() {
        return new MySQLUserDAO();
    }

}