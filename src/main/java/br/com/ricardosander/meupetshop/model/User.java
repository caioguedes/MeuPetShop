package br.com.ricardosander.meupetshop.model;

/**
 * Representa um usuário logado.
 */
public class User {

    /**
     * Identificador do usuário.
     */
    private final long id;

    /**
     * E-mail do usuário.
     */
    private final String email;

    /**
     * Senha do usuário.
     */
    private final String senha;

    /**
     * @param id    Identificador do usuário.
     * @param email E-mail do usuário.
     * @param senha Senha do usuário.
     */
    public User(long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    /**
     * @return Identificador do usuário.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Senha do usuário.
     */
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