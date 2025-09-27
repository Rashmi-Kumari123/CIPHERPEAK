package org.cipherpeak.model;

import java.util.Map;

public class Student {
    private String name;
    private Map<String, Integer> subjectMarks; // subject -> marks

    public Student(String name, Map<String, Integer> subjectMarks) {
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }
}

