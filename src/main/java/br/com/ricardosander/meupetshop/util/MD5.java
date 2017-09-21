package br.com.ricardosander.meupetshop.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Trata encriptação md5.
 */
public class MD5 {

    /**
     * Encripta uma String em md5.
     *
     * @param value Valor para ser encriptado.
     * @return Valor encriptado em md5.
     * @throws NoSuchAlgorithmException Erro ao buscar algortimo de encriptação.
     */
    public String encrypt(String value) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("MD5");

        //Update input string in message digest
        digest.update(value.getBytes(), 0, value.length());

        //Converts message digest value in base 16 (hex)
        return new BigInteger(1, digest.digest()).toString(16);
    }

}
