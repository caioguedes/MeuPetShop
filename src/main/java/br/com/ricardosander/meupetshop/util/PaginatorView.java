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
     * Requisição.
     */
    private final HttpServletRequest request;

    /**
     * Paginador.
     */
    private final Paginator paginator;

    private String uri;

    /**
     * Construtor.
     */
    private final StringBuilder urlParametersBuilder;

    /**
     * @param request        Requisição.
     * @param totalRegisters Total de registros para serem paginados.
     */
    public PaginatorView(HttpServletRequest request, int totalRegisters) {

        int currentPage;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (Exception exception) {
            currentPage = 1;
        }

        this.paginator = new Paginator(currentPage, totalRegisters);
        this.request = request;
        urlParametersBuilder = new StringBuilder();
    }

    private String getUri() {

        if (uri == null) {
            uri = request.getRequestURI();
        }
        return uri;
    }

    public String getFirstPage() {
        return this.getUri() + this.getParameters(this.paginator.getFirstPage());
    }

    public String getLastPage() {
        return this.getUri() + this.getParameters(this.paginator.getLastPage());
    }

    public String getPreviousPage() {
        return this.getUri() + this.getParameters(this.paginator.getPreviousPage());
    }

    public String getNextPage() {
        return this.getUri() + this.getParameters(this.paginator.getNextPage());
    }

    public String getPage(int page) {
        return this.getUri() + this.getParameters(page);
    }

    public int getTotal() {
        return this.paginator.getTotalRegister();
    }

    public int getCurrentPage() {
        return this.paginator.getCurrentPage();
    }

    public int getPages() {
        return this.paginator.getPages();
    }

    public boolean isFirstPage() {
        return this.getCurrentPage() == this.paginator.getFirstPage();
    }

    public boolean isLastPage() {
        return this.getCurrentPage() == this.paginator.getLastPage();
    }

    public boolean isPreviousPage() {
        return this.getCurrentPage() == this.paginator.getPreviousPage();
    }

    public boolean isNextPage() {
        return this.getCurrentPage() == this.paginator.getNextPage();
    }

    public boolean isPage(int page) {
        return this.getCurrentPage() == page;
    }

    public int firstListedPage() {
        return this.paginator.getFirstListedPage();
    }

    public int getLastListedPage() {
        return this.paginator.getLastListedPage();
    }

    /**
     * Retorna uma string com os parâmetros para uma determinada página.
     *
     * @param page Página.
     * @return String com todos parâmetros para a página.
     */
    public String getParameters(int page) {

        if (urlParametersBuilder.length() == 0) {
            this.process();
        }

        StringBuilder stringBuilder = new StringBuilder(urlParametersBuilder.toString());

        if (stringBuilder.length() == 0) {
            stringBuilder.append("?");
        } else {
            stringBuilder.append("&");
        }

        stringBuilder.append("page").append("=").append(page);

        return stringBuilder.toString();
    }

    public int getRegistersPerPage() {
        return this.paginator.getRegistersPerPage();
    }

    public int getOffSet() {
        return this.paginator.getOffSet();
    }

    /**
     * Processa os parâmetros da requisição em uma String.
     */
    private void process() {

        String parameterName;
        String parameterValue;
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

    }
}
