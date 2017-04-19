package ru.kss.app;

import org.junit.Test;
import ru.kss.bank.Bank;
import ru.kss.clients.Juridical;
import ru.kss.clients.exceptions.ClientExistsException;

/**
 * @author sk10271
 */
public class BankTest {
    @Test
    public void addClient() throws ClientExistsException {
        Bank bank = new Bank();
        Juridical juridical = new Juridical("Joyetech", false, "Vapes");
        bank.addClient(juridical);
    }
}