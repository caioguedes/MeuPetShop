package br.com.ricardosander.meupetshop.model;

import java.time.LocalDate;

/**
 * Model de um Pet(Animal).
 */
public class Pet {

    /**
     * Código identificador.
     */
    private long id;

    /**
     * Nome.
     */
    private String name;

    /**
     * Espécie.
     */
    private String species;

    /**
     * Raça.
     */
    private String breed;

    /**
     * Pêlo.
     */
    private String fur;

    /**
     * Pelagem.
     */
    private String pelage;

    /**
     * Porte
     */
    private String mien;

    /**
     * Peso.
      */
    private double weight;

    /**
     * Nascimento.
     */
    private LocalDate birth;

    /**
     * Cadastro
     */
    private LocalDate register;

    /**
     * Castrado.
     */
    private boolean castrated;

    /**
     * Observações.
     */
    private String comments;

    /**
     * Sexo.
     */
    private String gender;

    /**
     * Cliente pacote.
     */
    private boolean clientPacket;

    /**
     * Usuário.
     */
    private User user;

    /**
     * Proprietário.
     */
    private Owner owner;

    public Pet(long id, String name, String species, String breed, String fur, String pelage, String mien, double weight, LocalDate birth, LocalDate register, boolean castrated, String comments, String gender, boolean clientPacket, User user, Owner owner) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.fur = fur;
        this.pelage = pelage;
        this.mien = mien;
        this.weight = weight;
        this.birth = birth;
        this.register = register;
        this.castrated = castrated;
        this.comments = comments;
        this.gender = gender;
        this.clientPacket = clientPacket;
        this.user = user;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public String getFur() {
        return fur;
    }

    public String getPelage() {
        return pelage;
    }

    public String getMien() {
        return mien;
    }

    public double getWeight() {
        return weight;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public LocalDate getRegister() {
        return register;
    }

    public boolean isCastrated() {
        return castrated;
    }

    public String getComments() {
        return comments;
    }

    public String getGender() {
        return gender;
    }

    public boolean isClientPacket() {
        return clientPacket;
    }

    public User getUser() {
        return user;
    }

    public Owner getOwner() {
        return owner;
    }

}