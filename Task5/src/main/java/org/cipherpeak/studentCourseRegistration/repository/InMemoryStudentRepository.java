package org.cipherpeak.studentCourseRegistration.repository;



import org.cipherpeak.studentCourseRegistration.model.Student;
import java.util.*;

public class InMemoryStudentRepository implements StudentRepository {
    private final Map<String, Student> students = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student findById(String id) {
        return students.get(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
}

