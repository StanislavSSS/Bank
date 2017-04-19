package ru.kss.bank.exceptions;

import ru.kss.accounts.Account;

/**
 * Created by sk10271 on 19.04.2017.
 */
public class AccountNotExistsException extends Exception {
    private String exceptionMessage;
    private Account account;

    public AccountNotExistsException(String exceptionMessage, Account account) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
        this.account = account;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public Account getAccount() {
        return account;
    }
}
