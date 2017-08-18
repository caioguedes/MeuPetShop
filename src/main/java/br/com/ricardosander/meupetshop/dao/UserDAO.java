package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.User;

public interface UserDAO {

    User find(String email, String senha);

}