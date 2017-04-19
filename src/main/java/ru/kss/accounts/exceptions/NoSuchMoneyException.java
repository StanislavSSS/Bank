package ru.kss.accounts.exceptions;

import ru.kss.accounts.Account;

/**
 * Created by sk10271 on 19.04.2017.
 */
public class NoSuchMoneyException extends Exception {
    private Account account;
    private String exceptionMessage;

    public NoSuchMoneyException(String exceptionMessage, Account account) {
        super(exceptionMessage);
        this.account = account;
        this.exceptionMessage = exceptionMessage;
    }

    public Account getAccount() {
        return account;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
