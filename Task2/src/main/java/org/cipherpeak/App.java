package org.cipherpeak;

import org.cipherpeak.model.Student;
import org.cipherpeak.service.InputHandler;
import org.cipherpeak.service.GradeCalculator;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        GradeCalculator gradeCalculator = new GradeCalculator();

        String name = inputHandler.takeStudentName();
        Map<String, Integer> marks = inputHandler.takeMarksInput();

        Student student = new Student(name, marks);

        int total = gradeCalculator.calculateTotal(student.getSubjectMarks());
        double average = gradeCalculator.calculateAverage(student.getSubjectMarks());
        String grade = gradeCalculator.calculateGrade(average);

        System.out.println("\n--- Student Result ---");
        System.out.println("Name: " + student.getName());
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + average);
        System.out.println("Grade: " + grade);
    }
}
