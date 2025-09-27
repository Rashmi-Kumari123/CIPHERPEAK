package org.cipherpeak.service;

import java.util.Map;

public class GradeCalculator {

    public int calculateTotal(Map<String, Integer> marks) {
        return marks.values().stream().mapToInt(Integer::intValue).sum();
    }

    public double calculateAverage(Map<String, Integer> marks) {
        return calculateTotal(marks) / (double) marks.size();
    }

    public String calculateGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 60) return "B";
        else if (percentage >= 40) return "C";
        else return "F";
    }
}
