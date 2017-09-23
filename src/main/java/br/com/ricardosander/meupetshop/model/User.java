package br.com.ricardosander.meupetshop.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
     * Flash messages para o usuário.
     */
    private Map<String, String> flashMessage;

    /**
     * @param id    Identificador do usuário.
     * @param email E-mail do usuário.
     * @param senha Senha do usuário.
     */
    public User(long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.flashMessage = new HashMap<>();
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

    /**
     * Retorna as flash messages, removendo-as do objeto User.
     *
     * @return Flash messages para o usuário.
     */
    public Map<String, String> getFlashMessages() {

        Map<String, String> flashMessages = Collections.unmodifiableMap(flashMessage);

        flashMessage = new HashMap<>();

        return flashMessages;
    }

    /**
     * Retorna uma flash message, removendo-a do objeto User.
     *
     * @param messageName Nome (chave) da mensagem.
     * @return Texto da flash message.
     */
    public String getFlashMessage(String messageName) {

        String flashMessage = this.flashMessage.get(messageName);
        if (flashMessage != null) {
            this.flashMessage.remove(messageName);
        }

        return flashMessage;
    }

    /**
     * Adiciona uma flash message no User.
     *
     * @param messageName Chave da flash message.
     * @param message     Texto da flash message.
     */
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

}