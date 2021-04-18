package net.therap.controller;

import net.therap.model.Course;
import net.therap.model.Trainee;
import net.therap.service.CourseService;
import net.therap.validator.CourseValidator;
import net.therap.validator.TraineeValidator;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 3/31/21
 */
public class CourseController {

//    public void getCourseById() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter Course Id: ");
//        int courseId = input.nextInt();
//
//        CourseService courseProcessor = new CourseService();
//        Course course = courseProcessor.getCourse(courseId);
//        courseProcessor.processCourse(course);
//    }

    public void getCoursesByTraineeId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Trainee Id: ");
        int traineeId = input.nextInt();
        TraineeValidator tv = new TraineeValidator();
        if (tv.isValidId(traineeId)) {
            CourseService courseProcessor = new CourseService();
            Set<Course> courses = courseProcessor.getCourses(traineeId);
            courseProcessor.processCourses(courses);
        }
        else {
            System.out.println("\n************************** Invalid Trainee Id *************************");
        }
    }

    public void getAllCourses(){
        CourseService courseProcessor = new CourseService();
        Set<Course> courses = courseProcessor.getAll();
        courseProcessor.processCourses(courses);
    }

    public void insertCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course Title: ");
        String courseName = input.nextLine();
        CourseValidator courseValidator = new CourseValidator();
        if (courseValidator.isValidName(courseName)) {
            Course course = new Course();
            course.setTitle(courseName);
            CourseService courseService = new CourseService();
            courseService.insertCourse(course);
        } else {
            System.out.println("Not a valid Name ");
        }
    }

    public void updateCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new Course Name: ");
        String newName = input.nextLine();
        System.out.println("Enter Course id: ");
        int courseId = input.nextInt();

        CourseService courseService = new CourseService();
        Course course = new Course();
        course.setId(courseId);
        course.setTitle(newName);
        courseService.updateCourse(course);

    }

    public void deleteCourse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course id: ");
        int courseId = input.nextInt();
        CourseService courseService = new CourseService();
        Course course = new Course();
        course.setId(courseId);
        courseService.deleteCourse(course);
    }
}
