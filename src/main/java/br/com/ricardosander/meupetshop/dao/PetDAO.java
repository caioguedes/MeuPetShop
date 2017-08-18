package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import java.util.List;

public interface PetDAO {

    List<Pet> find(User user);

}