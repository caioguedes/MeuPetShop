package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.User;

import java.util.HashMap;
import java.util.Map;

public class StaticUserDAO implements UserDAO {

    private final static Map<String, User> USERS = new HashMap<>();
    static {
        USERS.put("rcksander@gmail.com", new User(1, "rcksander@gmail.com","123"));
    }

    StaticUserDAO() {

    }

    @Override
    public User find(String email, String senha) {

        if (!USERS.containsKey(email)) {
            return null;
        }

        User user = USERS.get(email);

        if (!user.getSenha().equals(senha)) {
            return null;
        }

        return user;
    }

}