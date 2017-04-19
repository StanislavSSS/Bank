package ru.kss.accounts.exceptions;

import ru.kss.accounts.Account;

/**
 * Created by sk10271 on 19.04.2017.
 */
public class NoSuchMoneyException extends Exception {
    private String exceptionMessage;

    public NoSuchMoneyException(String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
