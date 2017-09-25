package br.com.ricardosander.meupetshop.model;

/**
 * Define o tamanho do Pet.
 */
public enum PetSize {

    Mini, Small, Medium, Large, Giant;

    @Override
    public String toString() {

        switch (this) {

            case Mini:
                return "Mini";

            case Small:
                return "Pequeno";

            case Medium:
                return "Médio";

            case Large:
                return "Grande";

            case Giant:
                return "Gigante";

            default:
                return "";

        }
    }
}
