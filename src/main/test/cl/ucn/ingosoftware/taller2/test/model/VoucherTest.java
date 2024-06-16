package cl.ucn.ingosoftware.taller2.test.model;

import cl.ucn.ingsoftware.taller2.taller2.model.Voucher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class VoucherTest {

    private Voucher voucher;

    @BeforeEach
    public void setUp() {
        List<String> services = new ArrayList<>();
        services.add("service");

        voucher = new Voucher("a3fg", "15/06/2024 20:40",
                "15/12/2024 20:40", services);
    }

    @Test
    public void testGetId() {
        Assertions.assertEquals("a3fg", voucher.getId());
    }

    @Test
    public void testGetDate() {
        Assertions.assertEquals("15/06/2024 20:40", voucher.getDate());
    }

    @Test
    public void testGetExpireDate() {
        Assertions.assertEquals("15/12/2024 20:40", voucher.getExpiredDate());
    }

    @Test
    public void testGetServices() {
        List<String> services = new ArrayList<>();
        services.add("service");

        Assertions.assertEquals(services, voucher.getServices());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("[id = a3fg, date = 15/06/2024 20:40, expire_date = 15/12/2024 20:40]",
                voucher.toString());
    }

}
