package br.com.ricardosander.meupetshop.validator;

import java.util.Map;

/**
 * Interface que representa o comportamento de um validador.
 */
public interface Validator<T> {

    /**
     * Realiza a validação em um objeto T.
     *
     * @param object Objeto para ser validado.
     * @return Map com erros encontrados na validação.
     */
    Map<String, String> validate(T object);

}