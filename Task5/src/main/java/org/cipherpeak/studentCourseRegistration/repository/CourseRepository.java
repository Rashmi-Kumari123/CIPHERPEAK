package org.cipherpeak.studentCourseRegistration.repository;

import org.cipherpeak.studentCourseRegistration.model.Course;
import java.util.List;

public interface CourseRepository {
    void addCourse(Course course);
    Course findByCode(String code);
    List<Course> getAllCourses();
}

