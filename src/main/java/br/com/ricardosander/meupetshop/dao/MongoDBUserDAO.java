package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBUserDAO implements UserDAO {

    private static String collectionName = "users";

    private MongoCollection<Document> collection;

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

        return new User(
                firstFind.getObjectId("_id").getTimestamp(),
                firstFind.getString("username"),
                firstFind.getString("password")
        );
    }

}
