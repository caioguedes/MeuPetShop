package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.model.*;

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

        PETS.add(new Pet(
                1,
                "Piccolo",
                "Gato",
                "SRD",
                "Branco e Preto",
                "Longa",
                PetSize.Grande,
                12.4,
                LocalDate.of(2014, 11, 20),
                LocalDate.of(2015, 1, 10),
                true,
                "Meu gato amado",
                Gender.M,
                false,
                new User(1, "rcksander@gmail.com", ""),
                new Owner(1, "Ricardo Sander Lopes")
        ));

        PETS.add(new Pet(
                2,
                "Loki",
                "Cão",
                "Pincher",
                "Marrom",
                "Curto",
                PetSize.Pequeno,
                3.4,
                LocalDate.of(2010, 5, 2),
                LocalDate.of(2015, 10, 1),
                false,
                null,
                Gender.M,
                false,
                new User(1, "rcksander@gmail.com", ""),
                new Owner(2, "Scarlet Nedel")
        ));

    }

    @Override
    public List<Pet> find(User user) {
        return PETS.stream().filter(pet -> pet.getUser().equals(user)).collect(Collectors.toList());
    }

    @Override
    public Pet find(User user, long id) {
        return PETS.stream().filter(pet -> pet.getUser().equals(user) && pet.getId() == id).findFirst().get();
    }

    @Override
    public boolean insert(Pet pet) {
        return PETS.add(pet);
    }

    @Override
    public boolean remove(Pet pet) {

        for (Pet p : PETS) {

            if (p.getId() == pet.getId()) {
                PETS.remove(p);
                return true;
            }

        }

        return false;
    }

}