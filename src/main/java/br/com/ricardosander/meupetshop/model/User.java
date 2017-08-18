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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}