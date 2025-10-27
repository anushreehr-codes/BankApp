
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private List<String> transactionHistory;

    public Account(String accountNumber, String accountHolderName, double balance, String accountType, List<String> transactionHistory) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.transactionHistory = (transactionHistory != null) ? transactionHistory : new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Successfully withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showTransactionHistory() {
        if (transactionHistory == null || transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayUserInfo() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String accountHolderName, double balance, String accountType, List<String> transactionHistory) {
        super(accountNumber, accountHolderName, balance, accountType, transactionHistory);
    }

    // Overriding withdraw method with limit for savings account
    @Override
    public void withdraw(double amount) {
        if (amount > 1000) {
            System.out.println("Withdrawal limit exceeded for Savings Account.");
        } else {
            super.withdraw(amount);
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Bank Application");

        List<String> history = new ArrayList<>();
        SavingsAccount ac = new SavingsAccount("4567890", "Anushree", 500.0, "Savings", history);

        ac.deposit(2000);
        ac.withdraw(300);
        ac.displayBalance();
        ac.showTransactionHistory();
    }
}