package ru.kss.operations;

import ru.kss.accounts.Account;
import ru.kss.accounts.exceptions.NoSuchMoneyException;
import ru.kss.clients.Client;

import java.util.Calendar;

/**
 * Created by sk10271 on 19.04.2017.
 */
public class Operation {
    private Account accountFrom, accountTo;
    private Client clientFrom, clientTo;
    private int summ;
    private Calendar date;

    public Operation(Account accountFrom, Account accountTo, Client clientFrom, Client clientTo, int summ, Calendar date) {
        try {
            accountFrom.recalcSumm(-summ);
            accountTo.recalcSumm(summ);
        } catch (NoSuchMoneyException e) {
            e.printStackTrace();
        }

        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.clientFrom = clientFrom;
        this.clientTo = clientTo;
        this.summ = summ;
        this.date = date;
    }
}
