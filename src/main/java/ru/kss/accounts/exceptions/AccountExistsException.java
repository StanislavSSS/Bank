package ru.kss.accounts.exceptions;

import ru.kss.accounts.Account;

/**
 * Created by sk10271 on 19.04.2017.
 */
public class AccountExistsException extends Exception {
    private String exceptionMessage;
    private Account account;

    public AccountExistsException(String message, Account account){
        super(message);
        this.exceptionMessage = message;
        this.account = account;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public Account getAccount() {
        return account;
    }
}
