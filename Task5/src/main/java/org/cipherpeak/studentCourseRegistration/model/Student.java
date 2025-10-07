package org.cipherpeak.studentCourseRegistration.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String id;
    private final String name;
    private final List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Course> getRegisteredCourses() { return registeredCourses; }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
