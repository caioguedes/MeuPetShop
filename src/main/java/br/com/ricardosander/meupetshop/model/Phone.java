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
     * @param phone Telefone completo, com DDD e número.
     */
    public Phone(String phone) {

        String ddd;
        String number;

        try {
            ddd = phone.substring(0, 2);
            number = phone.substring(2, 9);
        } catch (Exception e) {
            ddd = null;
            number = null;
        }

        this.ddd = ddd;
        this.number = number;
    }

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
        return "(" + ddd + ")" + "-" + number;
    }

}
