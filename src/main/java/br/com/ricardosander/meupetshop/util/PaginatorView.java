package br.com.ricardosander.meupetshop.util;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

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

    public PaginatorView(String uri, String parameters, Paginator paginator) {
        this.uri = uri;
        this.parameters = parameters;
        this.paginator = paginator;
    }

    /**
     * Cria uma instância com base no HttpServletRequest.
     *
     * @param request        Origem da URI e parâmetros.
     * @param totalRegisters Total de registros da listagem.
     * @return Nova instância da classe.
     */
    public static PaginatorView from(HttpServletRequest request, int totalRegisters) {

        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception exception) {
            currentPage = 1;
        }

        String uri = request.getRequestURI();
        String parameters = PaginatorView.process(request);

        Paginator paginator = new Paginator(currentPage, totalRegisters);

        return new PaginatorView(uri, parameters, paginator);
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

    /**
     * Processa o HttpServlerRequest em uma String com parâmetros para a URI.
     *
     * @param request Origem dos parâmetros.
     * @return String contendo os parâmetros da URI (?name1=value1&name2=value2).
     */
    private static String process(HttpServletRequest request) {

        String parameterName;
        String parameterValue;

        StringBuilder urlParametersBuilder = new StringBuilder();

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {

            parameterName = parameterNames.nextElement();

            if (parameterName.equalsIgnoreCase("page")) {
                continue;
            }

            parameterValue = request.getParameter(parameterName);

            if (parameterValue == null) {
                continue;
            }

            if (urlParametersBuilder.length() == 0) {
                urlParametersBuilder.append("?");
            } else {
                urlParametersBuilder.append("&");
            }

            urlParametersBuilder.append(parameterName).append("=");
            try {
                urlParametersBuilder.append(URLEncoder.encode(parameterValue, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }

        }

        return urlParametersBuilder.toString();
    }
}
