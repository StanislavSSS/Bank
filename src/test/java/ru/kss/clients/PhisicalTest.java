package ru.kss.clients;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.kss.accounts.exceptions.IncorrectAccountNumberException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Pony on 08/04/2017.
 */
public class PhisicalTest {
    @Test
    public void createPhisicalTestGood() throws IncorrectAccountNumberException {
        Phisical phisical = new Phisical("Vladimir", "Volfovich", "Zhirinovsky",
                                         true, "Russia", "Moscow");
        assertTrue(phisical.addAccount("01234567890123456789"));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void createPhisicalTestBad() throws IncorrectAccountNumberException {
        Phisical phisical = new Phisical("Vladimir", "Volfovich", "Zhirinovsky",
                true, "Russia", "Moscow");

        thrown.expect(IncorrectAccountNumberException.class);

        assertFalse(phisical.addAccount("012345678901234567891"));
    }
}