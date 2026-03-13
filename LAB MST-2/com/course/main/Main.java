package com.course.main;

import com.course.model.*;
import com.course.service.*;
import com.course.exception.*;

public class Main {

    public static void main(String[] args) {

        CourseService service = new CourseService();

        Course c1 = new Course(1, "Java Programming", 2);
        Course c2 = new Course(2, "Data Structures", 3);

        service.addCourse(c1);
        service.addCourse(c2);

        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(102, "Bob");
        Student s3 = new Student(103, "Charlie");

        try {

            service.enrollStudent(1, s1);
            service.enrollStudent(1, s2);
            service.enrollStudent(1, s3); 

        } catch (CourseFullException |
                 CourseNotFoundException |
                 DuplicateEnrollmentException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\nCourses:");
        service.viewCourses();

        System.out.println("\nFile Data:");
        service.readFile();
    }
}