package service.impl;

import domain.Account;
import sevice.BankService;

import java.util.UUID;

public class BankServiceimpl implements BankService {

    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();

        //change later -->total size of accounts +1 and add prefix like AC(AC11).
        String accountNumber = UUID.randomUUID().toString();
        //ACCOUNT CREATED SUCCESSFULLY
        Account a = new Account(accountNumber,accountType,0,customerId);

        //SAVE ACCOUNT

        return "";
    }
}
