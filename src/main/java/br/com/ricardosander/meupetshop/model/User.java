package br.com.ricardosander.meupetshop.model;

public class User {

    private long id;

    private String email;

    private String senha;

    public User(long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}