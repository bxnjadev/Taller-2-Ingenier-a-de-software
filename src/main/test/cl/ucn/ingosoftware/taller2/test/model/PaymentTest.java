package cl.ucn.ingosoftware.taller2.test.model;

import cl.ucn.ingsoftware.taller2.taller2.model.CreditCard;
import cl.ucn.ingsoftware.taller2.taller2.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    private Payment payment;

    @BeforeEach
    public void setUp() {
        CreditCard creditCard = new CreditCard(
                "5652354345", 3,
                2027, "56532345"
        );

        payment = new Payment(creditCard, "a brief description", 5000);
    }

    @Test
    public void testCreditCard() {
        Assertions.assertEquals(
                new CreditCard(
                        "5652354345", 3,
                        2027, "56532345"
                ),
                payment.getCreditCard()
        );
    }

    @Test
    public void testDescription() {
        Assertions.assertEquals("a brief description", payment.getDescription());
    }

    @Test
    public void testAmount() {
        Assertions.assertEquals(5000, payment.getAmount());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("[credit_card = [number = 5652354345, mouth = 3, code = 56532345, year = 2027], description = a brief description, amount = 5000]",
                payment.toString());
    }

}
