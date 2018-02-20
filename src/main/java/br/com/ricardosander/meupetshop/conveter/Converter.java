package br.com.ricardosander.meupetshop.conveter;

/**
 * Defines a interface to convert between two objects.
 * @param <F> Type of from object.
 * @param <T> Type of to object.
 */
interface Converter<F, T> {

    /**
     * Converts a object from to a object T.
     * @param from Original value to be converted.
     * @return Object converted.
     */
    T convert(F from);
}
