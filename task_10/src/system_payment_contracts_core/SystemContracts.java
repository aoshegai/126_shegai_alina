package system_payment_contracts_core;

import java.util.HashMap;
import java.util.ArrayList;

public class SystemContracts {
    private HashMap<String, Contract> data;
    private SystemContracts() {
        data = new HashMap<>();
    }

    public void addContract(String number, String date) {
        StringBuilder error = new StringBuilder();
        if(number == null)
            error.append("Number can not be null\n");
        if(date == null)
            error.append("Date can not be null\n");
        if(!error.isEmpty())
            throw new IllegalArgumentException(error.toString());
        if((!data.containsKey(number)) && (date.length() == 8)) {
            data.put(number, new Contract(date));
        } else {
            System.out.println("договор с уже существующим номером");
        }
    }

    public static SystemContracts create() {
        return new SystemContracts();
    }

    public int getContractsCount() {
        return data.size();
    }
}
