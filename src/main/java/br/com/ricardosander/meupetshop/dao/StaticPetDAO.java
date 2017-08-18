package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DAO estática para Pets.
 */
public class StaticPetDAO implements PetDAO {

    /**
     * Lista onde são salvos todos os Pets.
     */
    private final static List<Pet> PETS = new LinkedList<>();

    static {

        List<Pet> pets = new LinkedList<>();
        pets.add(new Pet(
                1,
                "Piccolo",
                "Gato",
                "SRD",
                "Branco e Preto",
                "Longa",
                "Grande",
                12.4,
                LocalDate.of(2014, 11, 20),
                LocalDate.of(2015, 1, 10),
                true,
                "Meu gato amado",
                "Macho",
                false,
                new User(1, "rcksander@gmail.com", ""),
                new Owner(1, "Ricardo Sander Lopes")
        ));

        pets.add(new Pet(
                2,
                "Loki",
                "Cão",
                "Pincher",
                "Marrom",
                "Curto",
                "Pequeno",
                3.4,
                LocalDate.of(2010, 5, 2),
                LocalDate.of(2015, 10, 1),
                false,
                null,
                "Macho",
                false,
                new User(1, "rcksander@gmail.com", ""),
                new Owner(2, "Scarlet Nedel")
        ));

    }

    @Override
    public List<Pet> find(User user) {
        return PETS.stream().filter(pet -> pet.getUser().equals(user)).collect(Collectors.toList());
    }

}