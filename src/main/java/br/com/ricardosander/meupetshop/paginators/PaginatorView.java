package br.com.ricardosander.meupetshop.paginators;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe responsável pela operações de paginação dentro da view(jsp).
 */
public class PaginatorView {

    /**
     * Paginador.
     */
    private final Paginator paginator;

    /**
     * URI da listagem.
     */
    private final String uri;

    /**
     * Parâmetros da listagem.
     */
    private final String parameters;

    /**
     * @param uri            URI base.
     * @param parameters     Parâmetros da URI.
     * @param currentPage    Página atual.
     * @param totalRegisters Total de registros.
     */
    public PaginatorView(String uri, String parameters, int currentPage, int totalRegisters) {
        this.uri = uri;
        this.parameters = parameters;
        this.paginator = new Paginator(currentPage, totalRegisters);
    }

    /**
     * Cria uma instância com base no HttpServletRequest.
     *
     * @param request        Origem da URI e parâmetros.
     * @param totalRegisters Total de registros da listagem.
     * @return Nova instância da classe.
     */
    public static PaginatorView from(HttpServletRequest request, int totalRegisters) {
        return new HttpServletRequestToPaginatorView(request).create(totalRegisters);
    }

    /**
     * @return URI para a primeira página.
     */
    public String getFirstPage() {
        return this.getUri() + this.getParameters(this.paginator.getFirstPage());
    }

    /**
     * @return URI para a última página.
     */
    public String getLastPage() {
        return this.getUri() + this.getParameters(this.paginator.getLastPage());
    }

    /**
     * @return URI para a página anterior.
     */
    public String getPreviousPage() {
        return this.getUri() + this.getParameters(this.paginator.getPreviousPage());
    }

    /**
     * @return URI para a próxima página.
     */
    public String getNextPage() {
        return this.getUri() + this.getParameters(this.paginator.getNextPage());
    }

    /**
     * @param page Número da página para a URI.
     * @return URI para a página page.
     */
    public String getPage(int page) {
        return this.getUri() + this.getParameters(page);
    }

    /**
     * @return URI para a lista completa, na primeira página.
     */
    public String getCompleteList() {
        return this.getUri();
    }

    /**
     * @return Total de registros.
     */
    public int getTotal() {
        return this.paginator.getTotalRegister();
    }

    /**
     * @return Página atual.
     */
    public int getCurrentPage() {
        return this.paginator.getCurrentPage();
    }

    /**
     * @return Total de páginas.
     */
    public int getPages() {
        return this.paginator.getPages();
    }

    /**
     * @return Verifica se a página atual é a primeira página.
     */
    public boolean isFirstPage() {
        return this.getCurrentPage() == this.paginator.getFirstPage();
    }

    /**
     * @return Verifica se a página atual é a última página.
     */
    public boolean isLastPage() {
        return this.getCurrentPage() == this.paginator.getLastPage();
    }

    /**
     * @return Verifica se a página atual é a página anterior.
     */
    public boolean isPreviousPage() {
        return this.getCurrentPage() == this.paginator.getPreviousPage();
    }

    /**
     * @return Verifica se a página atual é a próxima página.
     */
    public boolean isNextPage() {
        return this.getCurrentPage() == this.paginator.getNextPage();
    }

    /**
     * @param page Página para verificação.
     * @return Se a página informada é a página atual.
     */
    public boolean isPage(int page) {
        return this.getCurrentPage() == page;
    }

    /**
     * @return Número da primeira página listada nas opções.
     */
    public int getFirstListedPage() {
        return this.paginator.getFirstListedPage();
    }

    /**
     * @return Número da última página listada nas opções.
     */
    public int getLastListedPage() {
        return this.paginator.getLastListedPage();
    }

    /**
     * @return Número de registros por página.
     */
    public int getRegistersPerPage() {
        return this.paginator.getRegistersPerPage();
    }

    /**
     * @return Offset/deslocamento.
     */
    public int getOffSet() {
        return this.paginator.getOffSet();
    }

    /**
     * @return URI da listagem.
     */
    private String getUri() {
        return uri;
    }

    /**
     * Retorna uma string com os parâmetros para uma determinada página.
     *
     * @param page Página.
     * @return String com todos parâmetros para a página.
     */
    private String getParameters(int page) {

        if (this.parameters.length() == 0) {
            return "?page=" + page;
        }

        return this.parameters + "&page=" + page;
    }

}
