package org.cipherpeak.model;

import java.util.Map;

public class Student {
    private final String name;
    private final Map<String, Integer> subjectMarks;

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

