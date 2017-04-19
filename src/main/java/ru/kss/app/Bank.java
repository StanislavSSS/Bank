package ru.kss.app;

import ru.kss.accounts.Account;
import ru.kss.clients.Client;
import ru.kss.clients.exceptions.ClientExistsException;

import java.util.HashSet;

/**
 * Created by Pony on 08/04/2017.
 */
public class Bank {
    private HashSet<Client> clients;
    private HashSet<Account> accounts;

    public Bank() {
        this.clients = new HashSet<Client>();
        this.accounts = new HashSet<Account>();
    }

    public HashSet<Client> getClients() {
        return clients;
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
}
