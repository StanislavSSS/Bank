package ru.kss.bank;

import ru.kss.accounts.Account;
import ru.kss.accounts.exceptions.NoSuchMoneyException;
import ru.kss.bank.exceptions.AccountNotExistsException;
import ru.kss.bank.exceptions.ClientNotExistsException;
import ru.kss.clients.Client;
import ru.kss.clients.exceptions.ClientExistsException;
import ru.kss.operations.Operation;

import java.util.Calendar;
import java.util.HashSet;

/**
 * Created by Pony on 08/04/2017.
 */
public class Bank {
    private HashSet<Client> clients;
    private HashSet<Account> accounts;
    private HashSet<Operation> operations;

    public Bank() {
        this.clients = new HashSet<Client>();
        this.accounts = new HashSet<Account>();
        this.operations = new HashSet<Operation>();
    }

    public HashSet<Client> getClients() {
        return clients;
    }

    public HashSet<Operation> getOperations() {
        return operations;
    }

    public HashSet<Account> getAccounts() {
        return accounts;
    }

    public boolean addClient(Client client) throws ClientExistsException {
        if (!this.clients.contains(client)) {
            this.clients.add(client);
            for (Account acc:client.getAccounts()
                    ) {if (!this.accounts.contains(acc))
                this.accounts.add(acc);
            }
            return true;
        }
        else{
            throw new ClientExistsException("Client " + client.getName() + " already exists!", client);
        }
    }

    public synchronized boolean createOperation(Account accountFrom, Account accountTo, Client clientFrom, Client clientTo, int summ) throws NoSuchMoneyException, AccountNotExistsException, ClientNotExistsException {
        if (!this.accounts.contains(accountFrom))
            throw new AccountNotExistsException("Account "  + accountFrom.getAccountNumber() + " doesn't exists in the Bank!", accountFrom);

        if (!this.clients.contains(clientFrom))
            throw new ClientNotExistsException("Client " + clientFrom.getName() + " doesn't exists in the Bank!", clientFrom);

        if (accountFrom.getSumm()<summ)
            throw new NoSuchMoneyException("Account " + accountFrom.getAccountNumber() + " doesn't have enough money!", accountFrom);

        if (!this.accounts.contains(accountTo))
            throw new AccountNotExistsException("Account "  + accountTo.getAccountNumber() + " doesn't exists in the Bank!", accountTo);

        if (!this.clients.contains(clientTo))
            throw new ClientNotExistsException("Client " + clientTo.getName() + " doesn't exists in the Bank!", clientTo);



        Operation operation = new Operation(accountFrom, accountTo, clientFrom, clientTo, summ, Calendar.getInstance());
        return this.operations.add(operation);
    }
}
