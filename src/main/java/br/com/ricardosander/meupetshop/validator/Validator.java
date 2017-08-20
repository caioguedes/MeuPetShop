package br.com.ricardosander.meupetshop.validator;

import java.io.InvalidObjectException;

/**
 * Interface que representa o comportamento de um validador.
 */
public interface Validator {
    void validate() throws InvalidObjectException;
}