package br.com.ricardosander.meupetshop.model;

/**
 * Representa um telefone
 */
public class Telefone {

    /**
     * DDD do telefone.
     */
    private final int ddd;

    /**
     * Número do telefone.
     */
    private final int number;

    /**
     * @param ddd    DDD do telefone.
     * @param number Número do telefone.
     */
    public Telefone(int ddd, int number) {
        this.ddd = ddd;
        this.number = number;
    }

    /**
     * @return DDD do telefone.
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * @return Número do telefone.
     */
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return ddd + "-" + number;
    }

}
