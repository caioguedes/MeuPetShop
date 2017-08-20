package br.com.ricardosander.meupetshop.validator;

import java.io.InvalidObjectException;
import java.util.List;

/**
 * Interface que representa o comportamento de um validador.
 */
public interface Validator {
    void validate() throws InvalidObjectException;
    List<String> getErrors();
}