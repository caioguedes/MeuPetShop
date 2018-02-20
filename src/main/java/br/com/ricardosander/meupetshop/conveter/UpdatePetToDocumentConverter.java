package br.com.ricardosander.meupetshop.conveter;

import br.com.ricardosander.meupetshop.model.Pet;
import org.bson.Document;

import java.time.ZoneId;
import java.util.Date;

/**
 * Pet to be update to Document Converter.
 */
public class UpdatePetToDocumentConverter implements Converter<Pet, Document> {

    @Override
    public Document convert(Pet from) {

        Long ownerId = from.getOwner() == null ? null : from.getOwner().getId();

        return new Document("name", from.getName())
                .append("species", from.getSpecies())
                .append("breed", from.getBreed())
                .append("fur", from.getFur())
                .append("pelage", from.getPelage())
                .append("size", from.getSize().name())
                .append("weight", from.getWeight())
                .append("birth", Date.from(from.getBirth().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .append("register", Date.from(from.getRegister().atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .append("castrated", from.isCastrated())
                .append("comments", from.getComments())
                .append("gender", from.getGender().name())
                .append("clientPacket", from.isClientPacket())
                .append("owner", ownerId);
    }

}
