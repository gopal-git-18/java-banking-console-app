package app;

import service.impl.BankServiceimpl;
import sevice.BankService;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankService bankService = new BankServiceimpl();

        boolean running = true;
        System.out.println("Welcome to console bank");
        while(running){
            System.out.println("""
                1) Open Account
                2) Deposit
                3) Withdraw
                4) Transfer
                5) Account Statement
                6) List Accounts
                7) Search Accounts by Customer Name 
                0) Exit
            """);
            System.out.println("CHOOSE: ");
            String choice = scanner.nextLine().trim();
            System.out.println("Choice: " + choice);

            switch(choice){
                case "1" -> openAccount(scanner, bankService);
                case "2" -> deposit(scanner);
                case "3" -> withdraw(scanner);
                case "4" -> Transfer(scanner);
                case "5" -> Statement(scanner);
                case "6" -> listAccounts(scanner);
                case "7" -> searchAccounts(scanner);
                case "0" -> running = false;
            }

        }
    }

    private static void openAccount(Scanner scanner,BankService bankService) {
        System.out.println("Customer Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Customer email: ");
        String email = scanner.nextLine().trim();
        System.out.println("Account Type (SAVINGS/CURRENT): ");
        String type = scanner.nextLine().trim();
        System.out.println("Initial deposite (optional,blank for 0): ");
        String amountStr = scanner.nextLine().trim();
        Double initial = Double.valueOf(amountStr);

        bankService.openAccount(name,email,type);
    }

    private static void deposit(Scanner scanner) {
    }

    private static void withdraw(Scanner scanner) {
    }

    private static void Transfer(Scanner scanner) {
    }

    private static void Statement(Scanner scanner) {
    }

    private static void listAccounts(Scanner scanner) {
    }

    private static void searchAccounts(Scanner scanner) {
    }


}
