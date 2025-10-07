package org.cipherpeak.studentCourseRegistration.service;

import org.cipherpeak.studentCourseRegistration.model.*;
import org.cipherpeak.studentCourseRegistration.repository.*;

public class RegistrationService {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public RegistrationService(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public boolean registerCourse(String studentId, String courseCode) {
        Student student = studentRepo.findById(studentId);
        Course course = courseRepo.findByCode(courseCode);

        if (student == null || course == null) return false;

        if (student.isAlreadyRegistered(courseCode)) {
            System.out.println("⚠️ Already registered for this course!");
            return false;
        }

        if (!course.hasAvailableSlot()) {
            System.out.println("⚠️ No slots available for this course!");
            return false;
        }

        course.enrollStudent();
        student.registerCourse(course);
        return true;
    }



    public boolean dropCourse(String studentId, String courseCode) {
        Student student = studentRepo.findById(studentId);
        Course course = courseRepo.findByCode(courseCode);

        if (student == null || course == null) return false;

        course.dropStudent();
        student.dropCourse(course);
        return true;
    }
}

