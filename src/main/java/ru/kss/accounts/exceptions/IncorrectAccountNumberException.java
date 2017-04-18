package ru.kss.accounts.exceptions;

/**
 * Created by Pony on 08/04/2017.
 */
public class IncorrectAccountNumberException extends Exception{
    private String accountNumber, exceptionMessage;
    private int length;

    public IncorrectAccountNumberException(String message, String accountNumber, int length){
        super(message);
        this.exceptionMessage = message;
        this.accountNumber = accountNumber;
        this.length = length;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public int getLength() {
        return length;
    }
}