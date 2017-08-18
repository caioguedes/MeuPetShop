package br.com.ricardosander.meupetshop.model;

public class Owner {

    private long id;

    private String name;

    public Owner(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}