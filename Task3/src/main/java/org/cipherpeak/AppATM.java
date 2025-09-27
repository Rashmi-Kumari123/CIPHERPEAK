package org.cipherpeak;

import org.cipherpeak.model.BankAccount;
import org.cipherpeak.service.ATM;
import org.cipherpeak.service.InputHandler;

public class AppATM {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String name = inputHandler.getStringInput("Enter account holder name: ");
        double initialBalance = inputHandler.getDoubleInput("Enter initial balance: $");

        BankAccount account = new BankAccount(name, initialBalance);
        ATM atm = new ATM(account, inputHandler);
        atm.start();
    }
}
