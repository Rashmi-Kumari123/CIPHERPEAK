package org.cipherpeak.service;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);

    // Take numeric input
    public double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next(); // discard invalid input
        }
        return scanner.nextDouble();
    }

    // Take menu option input
    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }

    // Take string input
    public String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
