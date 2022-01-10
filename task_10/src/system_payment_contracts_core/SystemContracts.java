package system_payment_contracts_core;

public class SystemContracts {
    private int contractsCount;
    private SystemContracts() {
        contractsCount = 0;
    }

    public void addContract(String number, String date) {
        if(number == null)
            throw new IllegalArgumentException("Number can not be null");
        if(date == null)
            throw new IllegalArgumentException("Date can not be null");
        contractsCount++;
    }

    public static SystemContracts create() {
        return new SystemContracts();
    }

    public int getContractsCount() {
        return contractsCount;
    }
}
