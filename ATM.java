package atmmachine;

import java.util.Scanner;

public class ATM {
    private float balance = 0.0f; // Initialize balance
    private final int PIN = 1122;

    public void checkPin() {
        System.out.println("Enter your pin:");
        try (Scanner sc = new Scanner(System.in)) { // Use try-with-resources to close Scanner
            int enteredPin = sc.nextInt();
            if (enteredPin == PIN) {
                menu();
            } else {
                System.out.println("Enter a valid pin");
            }
        }
    }

    public void menu() {
        System.out.println("Enter your choice");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");

        try (Scanner sc = new Scanner(System.in)) { // Use try-with-resources to close Scanner
            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> checkBalance();
                case 2 -> withdrawMoney();
                case 3 -> depositMoney();
                case 4 -> System.exit(0);
                default -> System.out.println("Enter a valid choice");
            }
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter Amount to Withdraw");
        try (Scanner sc = new Scanner(System.in)) { // Use try-with-resources to close Scanner
            float amount = sc.nextFloat();
            if (amount > balance) {
                System.out.println("Insufficient Balance");
            } else {
                balance -= amount;
                System.out.println("Money Withdrawal Successful");
            }
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter the Amount");
        try (Scanner sc = new Scanner(System.in)) { // Use try-with-resources to close Scanner
            float amount = sc.nextFloat();
            balance += amount;
            System.out.println("Money Deposited Successfully");
        }
        menu();
    }

    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}

