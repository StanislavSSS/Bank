package ru.kss.accounts;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import ru.kss.accounts.exceptions.IncorrectAccountNumberException;
import ru.kss.clients.Client;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Pony on 05/04/2017.
 */
public class Account {
    private static int counter;
    private String accountNumber;
    private Calendar openDate;
    private Date closeDate;
    private UUID ownerId, accountId;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    public Account(String accountNumber, Calendar openDate, UUID ownerId, UUID accountId) throws IncorrectAccountNumberException {
        int length = accountNumber.length();
        if (!(length == 20))
            throw new IncorrectAccountNumberException("Length of account number should be only 20", accountNumber, length);

        counter++;
        this.accountNumber = accountNumber;
        this.openDate = openDate;
        this.ownerId = ownerId;
        this.accountId = UUID.randomUUID();

        logger.info("Account " + accountNumber + " was added!");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Calendar getOpenDate() {
        return openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "\nAccount{" +
                "\naccountNumber='" + accountNumber + '\'' +
                "\n, openDate=" + openDate +
                "\n, closeDate=" + closeDate +
                "\n, ownerId=" + ownerId +
                "\n, accountId=" + accountId +
                '}';
    }
}