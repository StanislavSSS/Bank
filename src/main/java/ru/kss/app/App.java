package ru.kss.app;

import org.slf4j.LoggerFactory;
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

        Juridical joyetech = new Juridical("Joyetech", false, "Vapes");
        Juridical ford = new Juridical("Ford", false, "Auto");

        try {
            joyetech.addAccount("40702810000100000001", 100000);
            ford.addAccount("40702810000100000002", 100000);
        } catch (IncorrectAccountNumberException e) {
            e.printStackTrace();
        }

        try {
            bank.addClient(joyetech);
            bank.addClient(ford);
        } catch (ClientExistsException e) {
            logger.info(e.getExceptionMessage());
            e.printStackTrace();
        }




        /**logger.info(joyetech.toString());
        logger.info(String.valueOf(Account.getCounter()));*/
    }
}
