package org.cipherpeak.studentCourseRegistration;

import org.cipherpeak.studentCourseRegistration.model.*;
import org.cipherpeak.studentCourseRegistration.repository.*;
import org.cipherpeak.studentCourseRegistration.service.*;
import java.util.Scanner;

public class StudentRegistrationApp {
    public static void main(String[] args) {
        CourseRepository courseRepo = new InMemoryCourseRepository();
        StudentRepository studentRepo = new InMemoryStudentRepository();
        CourseService courseService = new CourseService(courseRepo);
        RegistrationService regService = new RegistrationService(studentRepo, courseRepo);

        // Seed Data
        courseService.addCourse(new Course("CS101", "Java Programming", "Intro to Java", 3, "Mon-Wed 10:00 AM"));
        courseService.addCourse(new Course("CS102", "DBMS", "Database Concepts", 2, "Tue-Thu 9:00 AM"));
        studentRepo.addStudent(new Student("S01", "Rashmi Kumari"));
        studentRepo.addStudent(new Student("S02", "Rimmi Pandey"));

        Scanner sc = new Scanner(System.in);
        String studentId = "S02";

        System.out.println("\n🎓 Welcome to the Course Registration System!");
        while (true) {
            System.out.println("\n1. View All Courses\n2. Register Course\n3. Drop Course\n4. View My Courses\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    courseService.getAllCourses().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter Course Code to Register: ");
                    if (regService.registerCourse(studentId, sc.nextLine()))
                        System.out.println("✅ Course registered successfully!");
                    else
                        System.out.println("❌ Registration failed.");
                    break;
                case 3:
                    System.out.print("Enter Course Code to Drop: ");
                    if (regService.dropCourse(studentId, sc.nextLine()))
                        System.out.println("✅ Course dropped successfully!");
                    else
                        System.out.println("❌ Course drop failed.");
                    break;
                case 4:
                    System.out.println("📚 Your Courses:");
                    studentRepo.findById(studentId).getRegisteredCourses().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
