package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.User;

interface UserDAO {

    User find(String email, String senha);

    default UserDAO newUserDAO() {
        return new StaticUserDAO();
    }

}