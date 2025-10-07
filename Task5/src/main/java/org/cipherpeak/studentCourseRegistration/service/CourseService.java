package org.cipherpeak.studentCourseRegistration.service;

import org.cipherpeak.studentCourseRegistration.model.Course;
import org.cipherpeak.studentCourseRegistration.repository.CourseRepository;
import java.util.List;

public class CourseService {
    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void addCourse(Course course) {
        courseRepo.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    public Course getCourseByCode(String code) {
        return courseRepo.findByCode(code);
    }
}

