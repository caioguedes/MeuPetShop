package br.com.ricardosander.meupetshop.conveter;

import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.Phone;
import br.com.ricardosander.meupetshop.model.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts a Document to a Owner.
 */
public class DocumentToOwnerConverter implements Converter<Document, Owner> {

    /**
     * User who owns the owner.
     */
    private final User user;

    /**
     * @param user User who owns the owner.
     */
    public DocumentToOwnerConverter(User user) {
        this.user = user;
    }

    @Override
    public Owner convert(Document from) {

        double deptor = 0.0;
        if (from.getString("debtor") != null) {
            deptor = Double.parseDouble(from.getString("debtor"));
        }

        Owner owner = new Owner(from.getLong("_id"), from.getString("name"));
        owner.setAddress(from.getString("address"));
        owner.setComments(from.getString("comments"));
        owner.setDebtor(deptor);
        owner.setDistrict(from.getString("district"));

        if (from.get("phones") != null) {

            List<String> phones = (ArrayList<String>) from.get("phones");

            if (phones.size() > 0) {
                owner.setPhone(new Phone(phones.get(0)));
            }

            if (phones.size() > 1) {
                owner.setPhone2(new Phone(phones.get(1)));
            }

            if (phones.size() > 2) {
                owner.setPhone3(new Phone(phones.get(2)));
            }

            if (phones.size() > 3) {
                owner.setPhone4(new Phone(phones.get(3)));
            }

            if (phones.size() > 4) {
                owner.setPhone5(new Phone(phones.get(4)));
            }

        }

        owner.setSecondaryName(from.getString("secondaryName"));
        owner.setUser(user);

        return owner;
    }

}
