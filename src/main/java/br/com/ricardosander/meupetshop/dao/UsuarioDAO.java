package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.User;

interface UsuarioDAO {

    User find(String email, String senha);

    default UsuarioDAO newUsuarioDAO() {
        return new StaticUsuarioDAO();
    }

}