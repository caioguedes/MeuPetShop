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

    /**
     * Construtor.
     */
    private final StringBuilder urlParametersBuilder;

    /**
     * @param paginator Paginador.
     * @param request   Requisição.
     */
    public PaginatorView(Paginator paginator, HttpServletRequest request) {
        this.paginator = paginator;
        this.request = request;
        urlParametersBuilder = new StringBuilder();
    }

    /**
     * @return Paginador.
     */
    public Paginator getPaginator() {
        return paginator;
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
