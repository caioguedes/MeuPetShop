package br.com.ricardosander.meupetshop.model;

/**
 * Representa um telefone
 */
public class Phone {

    /**
     * DDD do telefone.
     */
    private final String ddd;

    /**
     * Número do telefone.
     */
    private final String number;

    /**
     * @param ddd    DDD do telefone.
     * @param number Número do telefone.
     */
    public Phone(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    /**
     * @return DDD do telefone.
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * @return Número do telefone.
     */
    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return ddd + "-" + number;
    }

}
