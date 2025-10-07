package org.cipherpeak.studentCourseRegistration.repository;



import org.cipherpeak.studentCourseRegistration.model.Student;
import java.util.List;

public interface StudentRepository {
    void addStudent(Student student);
    Student findById(String id);
    List<Student> getAllStudents();
}

