package br.com.ricardosander.meupetshop.model;

import java.util.HashMap;
import java.util.Map;

public class User {

    private final long id;

    private final String email;

    private final String senha;

    private final Map<String, String> flashMessage;

    public User(long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.flashMessage = new HashMap<>();
    }

    public String getSenha() {
        return senha;
    }

    public String getFlashMessage(String messageName) {

        String flashMessage = this.flashMessage.get(messageName);
        if (flashMessage != null) {
            this.flashMessage.remove(messageName);
        }

        return flashMessage;
    }

    public void addFlashMessage(String messageName, String message) {
        this.flashMessage.put(messageName, message);
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

    public long getId() {
        return id;
    }
}