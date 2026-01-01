package service.impl;

import domain.Account;
import domain.Transaction;
import domain.Type;
import repository.AccountRepository;
import repository.TransactionRepository;
import service.BankService;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



public class BankServiceimpl implements BankService {

    private final AccountRepository accountRepository = new AccountRepository();
    private final TransactionRepository transactionRepository = new TransactionRepository();

    @Override
    public String openAccount(String name, String email, String accountType) {
        String customerId = UUID.randomUUID().toString();

        //change later -->total size of accounts +1 and add prefix like AC(AC11).
//        String accountNumber = UUID.randomUUID().toString();
        //ACCOUNT CREATED SUCCESSFULLY
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber,accountType,(double)0,customerId);

        //SAVE ACCOUNT
        accountRepository.save(account);

        return accountNumber;
    }

    @Override
    public List<Account> listAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void deposit(String accountNumber, Double amount, String note) {
        Account account = accountRepository.findByNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("account not found: " + accountNumber));
        account.setBalance(account.getBalance() + amount);
        Transaction transaction = new Transaction(
                UUID.randomUUID().toString(),      // id
                Type.DEPOSITE,                      // type
                account.getAccountNumber(),        // accountNumber
                amount,                            // amount
                LocalDateTime.now(),               // timestamp
                note                               // note
        );

        transactionRepository.add(transaction);

    }

    private String getAccountNumber() {
        int size = accountRepository.findAll().size()+1;
        return String.format("AC%06d",size);
    }
}
