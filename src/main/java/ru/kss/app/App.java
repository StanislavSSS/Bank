package ru.kss.app;

import ru.kss.accounts.Account;
import ru.kss.accounts.exceptions.IncorrectAccountNumberException;
import ru.kss.clients.Juridical;
import ru.kss.clients.exceptions.ClientExistsException;

/**
 * @author sk10271
 */
public class App {
    public static void main(String[] args){
        Bank bank = new Bank();
        Juridical juridical = new Juridical("Joyetech", false, "Vapes");

        try {
            juridical.addAccount("40702810000100000001");
        } catch (IncorrectAccountNumberException e) {
            e.printStackTrace();
        }

        try {
            boolean b = bank.addClient(juridical);
        } catch (ClientExistsException e) {
            System.out.println(e.getExceptionMessage());
            e.printStackTrace();
        }

        System.out.println(juridical.toString());
        System.out.println(Account.getCounter());
    }
}
