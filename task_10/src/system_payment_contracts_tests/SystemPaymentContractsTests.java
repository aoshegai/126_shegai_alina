package system_payment_contracts_tests;

import org.junit.*;
import system_payment_contracts_core.*;

public class SystemPaymentContractsTests extends Assert {
    @Test
    public void create_CreatePaymentContracts_ContractsCountEqualsZero() {
        SystemContracts paymentContractsList = SystemContracts.create();
        assertEquals(0, paymentContractsList.getContractsCount());
    }
}
