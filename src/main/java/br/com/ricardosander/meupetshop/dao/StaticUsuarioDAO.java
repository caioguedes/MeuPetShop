package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.User;

import java.util.HashMap;
import java.util.Map;

public class StaticUsuarioDAO implements UsuarioDAO {

    private final static Map<String, User> USUARIOS = new HashMap<>();
    static {
        USUARIOS.put("rcksander@gmail.com", new User(1, "rcksander@gmail.com","123"));
    }

    StaticUsuarioDAO() {

    }

    @Override
    public User find(String email, String senha) {

        if (!USUARIOS.containsKey(email)) {
            return null;
        }

        User user = USUARIOS.get(email);

        if (!user.getSenha().equals(senha)) {
            return null;
        }

        return user;
    }

}