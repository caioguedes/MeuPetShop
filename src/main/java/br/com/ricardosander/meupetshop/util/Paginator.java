package br.com.ricardosander.meupetshop.util;

/**
 * Classe que auxiliar na paginação.
 */
public class Paginator {

    /**
     * Valor padrão de registros por páginas.
     */
    private static final int DEFAULT_REGISTERS_PER_PAGE = 20;

    /**
     * Página atual.
     */
    private final int currentPage;

    /**
     * Total de registros.
     */
    private final int totalRegister;

    /**
     * Número de registros por página.
     */
    private final int registersPerPage;

    /**
     * @param totalRegister Total de registros.
     */
    public Paginator(int totalRegister) {
        this.currentPage = this.filterCurrentPage(1);
        this.totalRegister = totalRegister;
        this.registersPerPage = DEFAULT_REGISTERS_PER_PAGE;
    }

    /**
     * @param currentPage   Página atual.
     * @param totalRegister Total de registros.
     */
    public Paginator(int currentPage, int totalRegister) {
        this.currentPage = this.filterCurrentPage(currentPage);
        this.totalRegister = this.filterTotalRegister(totalRegister);
        this.registersPerPage = DEFAULT_REGISTERS_PER_PAGE;
    }

    /**
     * @param currentPage      Página atual.
     * @param totalRegister    Total de registros.
     * @param registersPerPage Registros por página.
     */
    public Paginator(int currentPage, int totalRegister, int registersPerPage) {
        this.currentPage = this.filterCurrentPage(currentPage);
        this.totalRegister = this.filterTotalRegister(totalRegister);
        this.registersPerPage = this.filterRegisterPerPage(registersPerPage);
    }

    /**
     * @return Total de registros por página.
     */
    public int getRegistersPerPage() {
        return registersPerPage;
    }

    /**
     * @return Página atual.
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @return Total de registros.
     */
    public int getTotalRegister() {
        return totalRegister;
    }

    /**
     * @return Primeira página na listagem.
     */
    public int getFirstListedPage() {

        if (currentPage < 3) {
            return 1;
        }

        if (currentPage > (this.getLastPage() - 2)) {
            return currentPage - 2 - (currentPage - (this.getLastPage() - 2));
        }

        return currentPage - 2;
    }

    /**
     * @return Última página na listagem.
     */
    public int getLastListedPage() {

        if (currentPage > (this.getLastPage() - 2)) {
            return this.getLastPage();
        }

        if (currentPage < 3) {
            return currentPage + 2 + (3 - currentPage);
        }

        return currentPage + 2;
    }

    /**
     * @return Primeira página.
     */
    public int getFirstPage() {
        return 1;
    }

    /**
     * @return Última página.
     */
    public int getLastPage() {
        return this.getPages();
    }

    /**
     * @return Número de páginas.
     */
    public int getPages() {

        if (totalRegister % registersPerPage != 0) {
            return totalRegister / registersPerPage + 1;
        }
        return totalRegister / registersPerPage;
    }

    /**
     * Válida o valor informado para o atributo currentPage e retorna um valor válido.
     *
     * @param currentPage Valor candidato para o atributo.
     * @return Valor válido para o atributo.
     */
    private int filterCurrentPage(int currentPage) {
        return currentPage > 0 ? currentPage : 1;
    }

    /**
     * Válida o valor informado para o atributo registerPerPage e retorna um valor válido.
     *
     * @param registersPerPage Valor candidato para o atributo.
     * @return Valor válido para o atributo.
     */
    private int filterRegisterPerPage(int registersPerPage) {
        return registersPerPage > 0 ? registersPerPage : DEFAULT_REGISTERS_PER_PAGE;
    }

    /**
     * Válida o valor informado para o atributo totalRegister e retorna um valor válido.
     *
     * @param totalRegister Valor candidato para o atributo.
     * @return Valor válido para o atributo.
     */
    private int filterTotalRegister(int totalRegister) {
        return totalRegister < 0 ? 0 : totalRegister;
    }

    /**
     * @return Offset, ou seja, deslocador.
     */
    public int getOffSet() {
        return (currentPage - 1) * registersPerPage;
    }

    /**
     * @return Página anterior da listagem.
     */
    public int getPreviousPage() {

        if (currentPage > this.getFirstPage()) {
            return currentPage - 1;
        }

        return this.getFirstPage();
    }

    /**
     * @return Pŕoxima página da listagem.
     */
    public int getNextPage() {

        if (currentPage < this.getLastPage()) {
            return currentPage + 1;
        }

        return this.getLastPage();
    }
}
