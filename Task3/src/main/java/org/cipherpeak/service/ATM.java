package org.cipherpeak.service;

import org.cipherpeak.model.BankAccount;

public class ATM {
    private BankAccount account;
    private InputHandler inputHandler;

    public ATM(BankAccount account, InputHandler inputHandler) {
        this.account = account;
        this.inputHandler = inputHandler;
    }

    // Display main menu
    public void showMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    // Run ATM operations
    public void start() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = inputHandler.getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    double depositAmount = inputHandler.getDoubleInput("Enter amount to deposit: $");
                    account.deposit(depositAmount);
                    System.out.println("Deposited: $" + depositAmount);
                    break;
                case 3:
                    double withdrawAmount = inputHandler.getDoubleInput("Enter amount to withdraw: $");
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawn: $" + withdrawAmount);
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
