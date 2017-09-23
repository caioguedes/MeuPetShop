package br.com.ricardosander.meupetshop.validator;

import java.io.InvalidObjectException;
import java.util.Map;

/**
 * Interface que representa o comportamento de um validador.
 */
public interface Validator<T> {

    /**
     * Valida um objeto.
     *
     * @throws InvalidObjectException Indica que o objeto informado não é válido.
     */
    Map<String, String> validate(T object) throws InvalidObjectException;

}