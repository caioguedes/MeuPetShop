package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.conveter.DocumentToPetConverter;
import br.com.ricardosander.meupetshop.conveter.InsertPetToDocumentConverter;
import br.com.ricardosander.meupetshop.conveter.UpdatePetToDocumentConverter;
import br.com.ricardosander.meupetshop.criteria.Criteria;
import br.com.ricardosander.meupetshop.database.DatabaseMongoDB;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.LinkedList;
import java.util.List;

/**
 * Mongo DAO for Pet.
 */
public class MongoDBPetDAO implements PetDAO {

    /**
     * Collection name.
     */
    private static String collectionName = "pets";

    /**
     * Collection connection.
     */
    private MongoCollection<Document> collection;

    /**
     * @param database Database connection.
     */
    MongoDBPetDAO(MongoDatabase database) {
        collection = database.getCollection(collectionName);
    }

    @Override
    public int count(User user, Criteria criteria) {

        Document query = createQuery(user, criteria);

        return (int) collection.count(query);
    }

    @Override
    public List<Pet> find(User user, Criteria criteria) {

        List<Pet> pets = new LinkedList<>();
        DocumentToPetConverter petConverter = new DocumentToPetConverter(user, null);

        Document query = createQuery(user, criteria);

        FindIterable<Document> documents = collection
                .find(query)
                .skip(criteria.getOffset())
                .limit(criteria.getLimit());

        for (Document document : documents) {
            pets.add(petConverter.convert(document));
        }

        return pets;
    }

    @Override
    public Pet find(User user, long id) {

        Document query = new Document("_id", id).append("user", user.getId());

        DocumentToPetConverter petConverter = new DocumentToPetConverter(user, null);

        Document first = collection.find(query).first();

        if (first == null) {
            return null;
        }

        return petConverter.convert(first);
    }

    @Override
    public boolean insert(Pet pet) {

        InsertPetToDocumentConverter converter = new InsertPetToDocumentConverter();

        MongoDatabase database = DatabaseMongoDB.getInstance();
        pet.setId(new MongoDBSequenceDAO(database).nextValue(collectionName));

        collection.insertOne(converter.convert(pet));

        return true;
    }

    @Override
    public boolean remove(Pet pet) {

        Document query = new Document("_id", pet.getId()).append("user", pet.getUser().getId());

        DeleteResult deleteResult = collection.deleteOne(query);

        return deleteResult.getDeletedCount() == 1;
    }

    @Override
    public boolean update(Pet pet) {

        UpdatePetToDocumentConverter converter = new UpdatePetToDocumentConverter();

        Document query = new Document("_id", pet.getId()).append("user", pet.getUser().getId());

        UpdateResult updateResult = collection.updateOne(query, new Document("$set", converter.convert(pet)));

        return updateResult.getModifiedCount() == 1;
    }

    /**
     * Creates a query based on user and criteria.
     *
     * @param user     User used as filter.
     * @param criteria Criteria with filters.
     * @return Query based on parameters.
     */
    private Document createQuery(User user, Criteria criteria) {

        Document query = new Document("user", user.getId());
        if (criteria.getName() != null && !criteria.getName().isEmpty()) {
            query = query.append("name", new Document("$regex", criteria.getName()));
        }

        return query;
    }

}