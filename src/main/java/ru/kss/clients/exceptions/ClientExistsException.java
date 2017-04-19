package ru.kss.clients.exceptions;

import ru.kss.clients.Client;

/**
 * @author sk10271
 */
public class ClientExistsException extends Exception {
    private Client client;
    private String exceptionMessage;

    public ClientExistsException(String message, Client client){
        super(message);
        this.client = client;
        this.exceptionMessage = message;
    }

    public Client getClient() {
        return client;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
