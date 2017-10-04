package br.com.ricardosander.meupetshop.model;

/**
 * Define os gêneros.
 */
public enum Gender {

    M("Macho"), F("Fêmea");

    /**
     * Nome do genêro.
     */
    private String name;

    /**
     * @param name Nome do gẽnero.
     */
    Gender(String name) {
        this.name = name;
    }

    /**
     * @return Nome do gênero.
     */
    public String getName() {
        return name;
    }

}