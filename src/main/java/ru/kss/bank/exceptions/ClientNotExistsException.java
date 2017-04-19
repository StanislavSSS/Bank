package ru.kss.bank.exceptions;

import ru.kss.clients.Client;

/**
 * Created by sk10271 on 19.04.2017.
 */
public class ClientNotExistsException extends Exception {
    private String exceptionMessage;
    private Client client;

    public ClientNotExistsException(String exceptionMessage, Client client) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
        this.client = client;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public Client getClient() {
        return client;
    }
}
