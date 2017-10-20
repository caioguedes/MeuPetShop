package br.com.ricardosander.meupetshop.criteria;

/**
 * Padrão critéria para buscas.
 */
public class Criteria {

    /**
     * Limit da busca.
     */
    private final int limit;

    /**
     * Inicio da busca.
     */
    private final int offset;

    /**
     * Nome da busca do pet.
     */
    private final String name;

    /**
     * @param limit  Limit da busca.
     * @param offset Inicio da busca.
     * @param name   Nome do pet para busca.
     */
    Criteria(int limit, int offset, String name) {
        this.limit = limit;
        this.offset = offset;
        this.name = name;
    }

    /**
     * @return Limit da busca.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @return Inicio da busca.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @return Nome da busca do pet.
     */
    public String getName() {
        return name;
    }
}
