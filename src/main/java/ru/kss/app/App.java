package ru.kss.app;

import org.slf4j.LoggerFactory;
import ru.kss.accounts.Account;
import ru.kss.accounts.exceptions.IncorrectAccountNumberException;
import ru.kss.bank.Bank;
import ru.kss.clients.Juridical;
import ru.kss.clients.exceptions.ClientExistsException;

/**
 * @author sk10271
 */
public class App {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(App.class);

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
            logger.info(e.getExceptionMessage());
            e.printStackTrace();
        }

        logger.info(juridical.toString());
        logger.info(String.valueOf(Account.getCounter()));
    }
}
