package org.cipherpeak.service;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public Map<String, Integer> takeMarksInput() {
        Map<String, Integer> marks = new HashMap<>();
        System.out.println("Enter number of subjects:");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter subject name: ");
            String subject = scanner.nextLine();
            System.out.print("Enter marks (0-100): ");
            int mark = Integer.parseInt(scanner.nextLine());
            marks.put(subject, mark);
        }
        return marks;
    }

    public String takeStudentName() {
        System.out.print("Enter student name: ");
        return scanner.nextLine();
    }
}
