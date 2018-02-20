package br.com.ricardosander.meupetshop.conveter;

import br.com.ricardosander.meupetshop.model.*;
import org.bson.Document;

import java.time.ZoneId;

/**
 * Converter of Document to Pet.
 */
public class DocumentToPetConverter implements Converter<Document, Pet> {

    /**
     * Pet's user.
     */
    private final User user;

    /**
     * Pet's Owner
     */
    private final Owner owner;

    /**
     * @param user  Pet's user.
     * @param owner Pet's Owner
     */
    public DocumentToPetConverter(User user, Owner owner) {
        this.user = user;
        this.owner = owner;
    }

    @Override
    public Pet convert(Document from) {

        return Pet.createPetWithId(
                from.getLong("_id"),
                from.getString("name"),
                from.getString("species"),
                from.getString("breed"),
                from.getString("fur"),
                from.getString("pelage"),
                PetSize.valueOf(from.getString("size")),
                from.getDouble("weight"),
                from.getDate("birth").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                from.getDate("register").toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                from.getBoolean("castrated"),
                from.getString("comments"),
                Gender.valueOf(from.getString("gender").charAt(0) + ""),
                from.getBoolean("clientPacket"),
                user,
                owner
        );

    }

}
