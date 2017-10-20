package br.com.ricardosander.meupetshop.criteria;

/**
 * Builder para criteria .
 */
public class CriteriaBuilder {

    private int limit;

    private int offset;

    private String name;

    public CriteriaBuilder limit(int limit) {
        this.limit = limit;
        return this;
    }

    public CriteriaBuilder offset(int offset) {
        this.offset = offset < 0 ? 0 : offset;
        return this;
    }

    public CriteriaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public Criteria build() {
        return new Criteria(limit, offset, name);
    }

}
