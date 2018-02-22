package br.com.ricardosander.meupetshop.conveter;

import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.Phone;
import org.bson.Document;

import java.util.LinkedList;
import java.util.List;

/**
 * Converter of a Owner to be inserted to a Document.
 */
public class InsertOwnerToDocumentConverter implements Converter<Owner, Document> {

    @Override
    public Document convert(Owner from) {

        Document document = new Document("_id", from.getId())
                .append("name", from.getName());

        if (from.getSecondaryName() != null && !from.getSecondaryName().isEmpty()) {
            document = document.append("secundaryName", from.getSecondaryName());
        }

        if (from.getAddress() != null && !from.getAddress().isEmpty()) {
            document = document.append("address", from.getAddress());
        }

        if (from.getComments() != null && !from.getComments().isEmpty()) {
            document = document.append("comments", from.getComments());
        }

        if (from.getDistrict() != null && !from.getDistrict().isEmpty()) {
            document = document.append("district", from.getDistrict());
        }

        if (from.getDebtor() != 0.0) {
            document = document.append("debtor", from.getDebtor());
        }

        if (from.getUser() != null) {
            document = document.append("user", from.getUser().getId());
        }

        List<String> phones = new LinkedList<>();

        if (from.getPhone() != null) {
            phones.add(from.getPhone().getDdd() + from.getPhone().getNumber());
        }

        if (from.getPhone2() != null) {
            phones.add(from.getPhone2().getDdd() + from.getPhone2().getNumber());
        }

        if (from.getPhone3() != null) {
            phones.add(from.getPhone3().getDdd() + from.getPhone3().getNumber());
        }

        if (from.getPhone4() != null) {
            phones.add(from.getPhone4().getDdd() + from.getPhone4().getNumber());
        }

        if (from.getPhone5() != null) {
            phones.add(from.getPhone5().getDdd() + from.getPhone5().getNumber());
        }

        if (!phones.isEmpty()) {
            document = document.append("phones", phones);
        }

        return document;
    }

}
