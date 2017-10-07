package br.com.ricardosander.meupetshop.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Controla as flash messages entre requisições.
 */
public class FlashMessage {

    /**
     * Map contendo o nome e as mensagens.
     */
    private Map<String, Object> messages;

    public FlashMessage() {
        this.messages = new HashMap<>();
    }

    /**
     * @return Map não modificável de flash messages.
     */
    public Map<String, Object> getMessages() {
        return Collections.unmodifiableMap(messages);
    }

    /**
     * Adiciona um objeto como flash message.
     *
     * @param name  Nome do da mensagem/objeto.
     * @param value Objeto/valor.
     */
    public void add(String name, Object value) {
        messages.put(name, value);
    }

    /**
     * Reseta o mapa de flash messages.
     */
    public void clear() {
        this.messages = new HashMap<>();
    }

}
