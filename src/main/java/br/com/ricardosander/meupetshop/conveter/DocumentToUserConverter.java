package br.com.ricardosander.meupetshop.conveter;

import br.com.ricardosander.meupetshop.model.User;
import org.bson.Document;

/**
 * Document to User Converter.
 */
public class DocumentToUserConverter implements Converter<Document, User> {

    @Override
    public User convert(Document from) {

        return new User(
                from.getLong("_id"),
                from.getString("username"),
                from.getString("password")
        );
    }
}
