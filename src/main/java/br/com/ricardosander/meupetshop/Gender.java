package br.com.ricardosander.meupetshop;

/**
 * Define os gêneros.
 */
public enum Gender {

    M, F;

    /**
     * Retorna um gênero de acordo com a String.
     *
     * @param value Valor para ser transformado. Considera o primeiro caracter, case insensitive.
     * @return M, F ou null.
     */
    public static Gender value(String value) {

        switch (value.substring(0, 1).toUpperCase()) {

            case "M":
                return M;

            case "F":
                return F;

            default:
                return null;
        }
    }

}