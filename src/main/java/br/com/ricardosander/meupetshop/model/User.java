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
    private Map<String, Object> flashMessage;

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
    public Map<String, Object> getFlashMessages() {

        Map<String, Object> flashMessages = Collections.unmodifiableMap(flashMessage);

        flashMessage = new HashMap<>();

        return flashMessages;
    }

    /**
     * Retorna um flash object, removendo-a do objeto User.
     *
     * @param objectName Nome (chave) do objeto.
     * @return Objeto flash message.
     */
    public Object getFlashMessage(String objectName) {

        Object flashObject = this.flashMessage.get(objectName);
        if (flashObject != null) {
            this.flashMessage.remove(objectName);
        }

        return flashObject;
    }

    /**
     * Adiciona um flash object no User.
     *
     * @param messageName Chave da flash message.
     * @param object      Flash object.
     */
    public void addFlashMessage(String messageName, Object object) {
        this.flashMessage.put(messageName, object);
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