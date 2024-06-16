package cl.ucn.ingosoftware.taller2.test.model;

import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditCardTest {

    private CreditCard creditCard;

    @BeforeEach
    public void setUp() {
        creditCard = new CreditCard(
                "5652354345", 3,
                2027, "56532345"
        );

    }

    @Test
    private void testGetNumber() {
        Assertions.assertEquals("5652354345", creditCard.getNumber());
    }

    @Test
    public void testGetMouth() {
        Assertions.assertEquals(3, creditCard.getMouth());
    }

    @Test
    public void testGetYear() {
        Assertions.assertEquals(2027, creditCard.getYear());
    }

    @Test
    public void testGetCode() {
        Assertions.assertEquals("56532345", creditCard.getCode());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("[number = 5652354345, mouth = 3, code = 56532345, year = 2027]",
                creditCard.toString());
    }

}
