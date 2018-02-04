package br.com.ricardosander.meupetshop.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import org.bson.Document;

/**
 * DAO to control sequences to collections.
 */
public class MongoDBSequenceDAO {

    /**
     * Connection to the collection.
     */
    private MongoCollection<Document> collection;

    /**
     * @param database MongoDB connection.
     */
    MongoDBSequenceDAO(MongoDatabase database) {
        collection = database.getCollection("sequences");
    }

    /**
     * Returns the next sequence value for a given collection.
     * @param collectionName Collection's name.
     * @return Next sequence value.
     */
    public long nextValue(String collectionName) {

        Document query = new Document("_id", collectionName);
        Document update = new Document("$inc", new Document("sequence", 1));
        FindOneAndUpdateOptions options = new FindOneAndUpdateOptions();
        options = options.projection(new Document("_id", 0));

        Document document = collection.findOneAndUpdate(query, update, options);

        return document.getLong("sequence");
    }

}
