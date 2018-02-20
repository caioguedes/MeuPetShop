package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.conveter.DocumentToUserConverter;
import br.com.ricardosander.meupetshop.model.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Mongo DAO for User.
 */
public class MongoDBUserDAO implements UserDAO {

    /**
     * Collection's name.
     */
    private static String collectionName = "users";

    /**
     * Collection's connection.
     */
    private MongoCollection<Document> collection;

    /**
     * @param database Database connection.
     */
    MongoDBUserDAO(MongoDatabase database) {
        collection = database.getCollection(collectionName);
    }

    @Override
    public User find(String username, String password) {

        Document query = new Document("username", username).append("password", password);

        Document firstFind = collection.find(query).first();

        if (firstFind == null) {
            return null;
        }

        return new DocumentToUserConverter().convert(firstFind);
    }

}
