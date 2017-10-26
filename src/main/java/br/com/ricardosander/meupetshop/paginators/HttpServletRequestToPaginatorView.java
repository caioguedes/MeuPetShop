package br.com.ricardosander.meupetshop.paginators;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

/**
 * Classe que realiza a conversão de um HttpServletRequest em PaginatorView.
 */
class HttpServletRequestToPaginatorView {

    /**
     * HttpServlerRequest para conversão.
     */
    private final HttpServletRequest httpServletRequest;

    /**
     * @param httpServletRequest HttpServlerRequest para conversão.
     */
    public HttpServletRequestToPaginatorView(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * Cria uma instância de PAginatorView.
     *
     * @param totalRegisters Total de registros da paginação.
     * @return
     */
    PaginatorView create(int totalRegisters) {
        return new PaginatorView(this.getUri(), this.getParameters(), this.getCurrentPage(), totalRegisters);
    }

    /**
     * @return Página atual.
     */
    private int getCurrentPage() {

        try {
            return Integer.parseInt(httpServletRequest.getParameter("page"));
        } catch (Exception exception) {
            return 1;
        }
    }

    /**
     * @return URI.
     */
    private String getUri() {
        return httpServletRequest.getRequestURI();
    }

    /**
     * @return Parâmetros da URI no formato ?param1=value1&param2=value2
     */
    private String getParameters() {

        String parameterName;
        String parameterValue;

        StringBuilder urlParametersBuilder = new StringBuilder();

        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {

            parameterName = parameterNames.nextElement();

            if (parameterName.equalsIgnoreCase("page")) {
                continue;
            }

            parameterValue = httpServletRequest.getParameter(parameterName);

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
