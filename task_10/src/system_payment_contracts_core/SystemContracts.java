package system_payment_contracts_core;

public class SystemContracts {
    private int contractsCount;
    private SystemContracts() {
        contractsCount = 0;
    }

    public void addContract(String number, String date) {
        contractsCount++;
    }

    public static SystemContracts create() {
        return new SystemContracts();
    }

    public int getContractsCount() {
        return contractsCount;
    }
}
