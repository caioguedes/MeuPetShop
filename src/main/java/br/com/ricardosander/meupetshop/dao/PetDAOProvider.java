package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.database.DatabaseMongoDB;

/**
 * PetDAO's provider .
 */
public class PetDAOProvider {

    /**
     * @return Returns a instance for PetDAO.
     */
    public PetDAO newPetDAO() {
        return new MongoDBPetDAO(DatabaseMongoDB.getInstance());
    }

}