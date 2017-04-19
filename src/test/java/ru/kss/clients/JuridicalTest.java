package ru.kss.clients;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.kss.accounts.exceptions.IncorrectAccountNumberException;

/**
 * Created by sk10271 on 19.04.2017.
 */
public class JuridicalTest {
    @Test
    public void createJuridical(){
        Juridical juridical = new Juridical("Joyetech", false, "Vapes");

        try {
            juridical.addAccount("40702810000100000001");
        } catch (IncorrectAccountNumberException e) {
            e.printStackTrace();
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createJuridicalBad() throws IncorrectAccountNumberException {
        Juridical juridical = new Juridical("Joyetech", false, "Vapes");

        thrown.expect(IncorrectAccountNumberException.class);

        juridical.addAccount("407028100001000000012");
    }
}