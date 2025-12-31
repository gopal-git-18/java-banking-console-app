package service.impl;

import domain.Account;
import repository.AccountRepository;
import service.BankService;

import java.util.UUID;

public class BankServiceimpl implements BankService {

    private final AccountRepository accountRepository = new AccountRepository();

    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();

        //change later -->total size of accounts +1 and add prefix like AC(AC11).
//        String accountNumber = UUID.randomUUID().toString();
        //ACCOUNT CREATED SUCCESSFULLY
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber,accountType,0,customerId);

        //SAVE ACCOUNT
        accountRepository.save(account);

        return accountNumber;
    }

    private String getAccountNumber() {
        int size = accountRepository.findAll().size()+1;
        return String.format("AC%06d",size);
    }
}
