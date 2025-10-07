package org.cipherpeak.studentCourseRegistration.repository;

import org.cipherpeak.studentCourseRegistration.model.Course;
import java.util.*;

public class InMemoryCourseRepository implements CourseRepository {
    private final Map<String, Course> courses = new HashMap<>();

    @Override
    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    @Override
    public Course findByCode(String code) {
        return courses.get(code);
    }

    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }
}

