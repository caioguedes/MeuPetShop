package br.com.ricardosander.meupetshop.criteria;

/**
 * Builder para criteria de pet.
 */
public class PetCriteriaBuilder {

    private int limit;

    private int offset;

    private String name;

    public PetCriteriaBuilder limit(int limit) {
        this.limit = limit;
        return this;
    }

    public PetCriteriaBuilder offset(int offset) {
        this.offset = offset < 0 ? 0 : offset;
        return this;
    }

    public PetCriteriaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PetCriteria build() {
        return new PetCriteria(limit, offset, name);
    }

}
