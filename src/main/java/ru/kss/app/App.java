package ru.kss.app;

import ru.kss.accounts.Account;
import ru.kss.accounts.exceptions.IncorrectAccountNumberException;
import ru.kss.clients.Juridical;

/**
 * @author sk10271
 */
public class App {
    public static void main(String[] args){
        Juridical juridical = new Juridical("Joyetech", false, "Vapes");

        try {
            juridical.addAccount("40702810000100000001");
        } catch (IncorrectAccountNumberException e) {
            e.printStackTrace();
        }

        try {
            juridical.addAccount("407028100001000000011");
        } catch (IncorrectAccountNumberException e) {
            e.printStackTrace();
        }

        System.out.println(juridical.toString());
        System.out.println(Account.getCounter());
    }
}
