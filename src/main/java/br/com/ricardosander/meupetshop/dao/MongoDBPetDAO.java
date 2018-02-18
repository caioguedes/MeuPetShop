package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.criteria.Criteria;
import br.com.ricardosander.meupetshop.database.DatabaseMongoDB;
import br.com.ricardosander.meupetshop.model.Gender;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.PetSize;
import br.com.ricardosander.meupetshop.model.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.time.ZoneId;
import java.util.Date;
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

        Document query = createQuery(user, criteria);

        FindIterable<Document> documents = collection
                .find(query)
                .skip(criteria.getOffset())
                .limit(criteria.getLimit());

        for (Document document : documents) {
            pets.add(new Pet(
                    document.getLong("_id"),
                    document.getString("name"),
                    document.getString("species"),
                    document.getString("breed"),
                    document.getString("fur"),
                    document.getString("pelage"),
                    PetSize.valueOf(document.getString("size")),
                    document.getDouble("weight"),
                    document.getDate("birth").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    document.getDate("register").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    document.getBoolean("castrated"),
                    document.getString("comments"),
                    Gender.valueOf(document.getString("gender").charAt(0) + ""),
                    document.getBoolean("clientPacket"),
                    user,
                    null
            ));
        }

        return pets;
    }

    @Override
    public Pet find(User user, long id) {

        Document query = new Document("_id", id).append("user", user.getId());

        Document first = collection.find(query).first();

        if (first == null) {
            return null;
        }

        return new Pet(
                first.getLong("_id"),
                first.getString("name"),
                first.getString("species"),
                first.getString("breed"),
                first.getString("fur"),
                first.getString("pelage"),
                PetSize.valueOf(first.getString("size")),
                first.getDouble("weight"),
                first.getDate("birth").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                first.getDate("register").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                first.getBoolean("castrated"),
                first.getString("comments"),
                Gender.valueOf(first.getString("gender")),
                first.getBoolean("clientPacket"),
                user,
                null);
    }

    @Override
    public boolean insert(Pet pet) {

        MongoDatabase database = DatabaseMongoDB.getInstance();
        final long sequence = new MongoDBSequenceDAO(database).nextValue(collectionName);

        Document document = new Document("name", pet.getName())
                .append("_id", sequence)
                .append("species", pet.getSpecies())
                .append("breed", pet.getBreed())
                .append("fur", pet.getFur())
                .append("pelage", pet.getPelage())
                .append("size", pet.getSize().name())
                .append("weight", pet.getWeight())
                .append("birth", Date.from(pet.getBirth().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .append("register", Date.from(pet.getRegister().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .append("castrated", pet.isCastrated())
                .append("comments", pet.getComments())
                .append("gender", pet.getGender().name())
                .append("clientPacket", pet.isClientPacket())
                .append("user", pet.getUser().getId())
                .append("owner", null);

        collection.insertOne(document);

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

        Document query = new Document("_id", pet.getId()).append("user", pet.getUser().getId());

        Document document = new Document("name", pet.getName())
                .append("species", pet.getSpecies())
                .append("breed", pet.getBreed())
                .append("fur", pet.getFur())
                .append("pelage", pet.getPelage())
                .append("size", pet.getSize().name())
                .append("weight", pet.getWeight())
                .append("birth", Date.from(pet.getBirth().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .append("register", Date.from(pet.getRegister().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .append("castrated", pet.isCastrated())
                .append("comments", pet.getComments())
                .append("gender", pet.getGender().name())
                .append("clientPacket", pet.isClientPacket())
                .append("owner", null);

        UpdateResult updateResult = collection.updateOne(query, new Document("$set", document));

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