package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.conveter.DocumentToOwnerConverter;
import br.com.ricardosander.meupetshop.conveter.InsertOwnerToDocumentConverter;
import br.com.ricardosander.meupetshop.conveter.UpdateOwnerToDocumentConverter;
import br.com.ricardosander.meupetshop.criteria.Criteria;
import br.com.ricardosander.meupetshop.database.DatabaseMongoDB;
import br.com.ricardosander.meupetshop.model.Owner;
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
 * MongoDB DAO for Owner.
 */
public class MongoDBOwnerDAO implements OwnerDAO {

    /**
     * Collection name.
     */
    private static String collectionName = "owners";

    /**
     * Collection connection.
     */
    private MongoCollection<Document> collection;

    /**
     * @param database Database connection.
     */
    MongoDBOwnerDAO(MongoDatabase database) {
        collection = database.getCollection(collectionName);
    }

    @Override
    public int count(User user, Criteria criteria) {

        Document query = createQuery(user, criteria);

        return (int) collection.count(query);
    }

    @Override
    public List<Owner> find(User user, Criteria criteria) {

        List<Owner> owners = new LinkedList<>();
        DocumentToOwnerConverter converter = new DocumentToOwnerConverter(user);

        Document query = createQuery(user, criteria);

        FindIterable<Document> documents = collection
                .find(query)
                .skip(criteria.getOffset())
                .limit(criteria.getLimit());

        for (Document document : documents) {
            owners.add(converter.convert(document));
        }

        return owners;
    }

    @Override
    public Owner find(User user, long id) {

        Document query = new Document("_id", id).append("user", user.getId());

        Document first = collection.find(query).first();

        if (first == null) {
            return null;
        }

        DocumentToOwnerConverter converter = new DocumentToOwnerConverter(user);

        return converter.convert(first);
    }

    @Override
    public boolean insert(Owner owner) {

        InsertOwnerToDocumentConverter converter = new InsertOwnerToDocumentConverter();

        MongoDatabase database = DatabaseMongoDB.getInstance();
        owner.setId(new MongoDBSequenceDAO(database).nextValue(collectionName));

        collection.insertOne(converter.convert(owner));

        return true;
    }

    @Override
    public boolean remove(Owner owner) {

        Document query = new Document("_id", owner.getId()).append("user", owner.getUser().getId());

        DeleteResult deleteResult = collection.deleteOne(query);

        return deleteResult.getDeletedCount() == 1;
    }

    @Override
    public boolean update(Owner owner) {

        UpdateOwnerToDocumentConverter converter = new UpdateOwnerToDocumentConverter();

        Document query = new Document("_id", owner.getId()).append("user", owner.getUser().getId());

        UpdateResult updateResult = collection.updateOne(query, converter.convert(owner));

        return updateResult.getModifiedCount() == 1;
    }

    /**
     * Creates a Document to query based on arguments.
     *
     * @param user     User to the query.
     * @param criteria Criteria to the query.
     * @return A document representing a query.
     */
    private Document createQuery(User user, Criteria criteria) {

        Document query = new Document("user", user.getId());

        if (criteria.getName() != null && !criteria.getName().isEmpty()) {
            query = query.append("name", new Document("$regex", criteria.getName()));
        }

        return query;
    }
}
