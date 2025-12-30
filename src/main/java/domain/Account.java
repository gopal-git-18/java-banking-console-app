package domain;

public class Account {
    private String accountNumber;
    private String customerId;
    private double balance;
    private String accountType;

    public Account(String accountNumber,String accountType,double balance, String customerId ) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.balance = balance;
        this.accountType = accountType;
    }
}
