package com.course.service;

import com.course.model.*;
import com.course.exception.*;

import java.io.*;
import java.util.*;

public class CourseService {

    private List<Course> courses = new ArrayList<>();
    private Map<Integer, Set<Integer>> enrollmentMap = new HashMap<>();

    private final String FILE_NAME = "courses.txt";

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void enrollStudent(int courseId, Student s)
            throws CourseFullException, CourseNotFoundException, DuplicateEnrollmentException {

        Course course = null;

        for (Course c : courses) {
            if (c.getCourseId() == courseId) {
                course = c;
                break;
            }
        }

        if (course == null) {
            throw new CourseNotFoundException("Course not found");
        }

        enrollmentMap.putIfAbsent(courseId, new HashSet<>());

        if (enrollmentMap.get(courseId).contains(s.getStudentId())) {
            throw new DuplicateEnrollmentException("Student already enrolled");
        }

        if (course.getEnrolledStudents() >= course.getMaxSeats()) {
            throw new CourseFullException("Course is full");
        }

        course.setEnrolledStudents(course.getEnrolledStudents() + 1);
        enrollmentMap.get(courseId).add(s.getStudentId());

        saveToFile(course, s);
    }

    public void viewCourses() {
        for (Course c : courses) {
            c.display();
        }
    }

    private void saveToFile(Course c, Student s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            bw.write(c.getCourseId() + "," +
                     c.getCourseName() + "," +
                     s.getStudentId() + "," +
                     s.getStudentName());
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File not found yet.");
        }
    }
}