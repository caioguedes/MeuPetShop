package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.database.DatabaseMongoDB;

/**
 * UserDAO's provider.
 */
public class UserDAOProvider {

    /**
     * @return Returns a UserDAO instance.
     */
    public UserDAO newUserDAO() {
        return new MongoDBUserDAO(DatabaseMongoDB.getInstance());
    }

}