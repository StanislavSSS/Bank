package ru.kss.clients;

import ru.kss.accounts.Account;
import ru.kss.accounts.exceptions.IncorrectAccountNumberException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by Pony on 05/04/2017.
 */
public abstract class Client {
    private static int counter;
    private UUID clientId;
    private String name;
    private boolean resident;
    private Calendar serviceDateStart, serviceDateEnd;
    private ArrayList<Account> accounts;

    public Client(String name, boolean resident) {
        counter++;
        this.clientId = UUID.randomUUID();
        this.name = name;
        this.resident = resident;
        this.serviceDateStart = Calendar.getInstance();
        this.accounts = new ArrayList<Account>();
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public UUID getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public boolean isResident() {
        return resident;
    }

    public Calendar getServiceDateStart() {
        return serviceDateStart;
    }

    public Calendar getServiceDateEnd() {
        return serviceDateEnd;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static int getCounter() {
        return counter;
    }

    public boolean addAccount(String accountNumber) throws IncorrectAccountNumberException {
        Account account = new Account(accountNumber, Calendar.getInstance(), getClientId(), UUID.randomUUID());
        if (this.getAccounts().contains(account))
            return false;
        else
            return accounts.add(account);

    }

    /*TODO*/
    public boolean addAccounts(ArrayList<Account> accounts){
        UUID clientid = getClientId();

        for (Account account:accounts){
            if (account.getOwnerId().equals(account.getOwnerId()))
            this.accounts.add(account);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" +
                "\nclientId=" + clientId +
                "\n, name='" + name + '\'' +
                "\n, resident=" + resident +
                "\n, serviceDateStart=" + serviceDateStart +
                "\n, serviceDateEnd=" + serviceDateEnd +
                "\n, accounts=" + accounts +
                '}';
    }
}