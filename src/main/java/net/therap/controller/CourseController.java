package net.therap.controller;

import net.therap.model.Course;
import net.therap.service.CourseService;
import net.therap.validator.CourseValidator;
import net.therap.validator.TraineeValidator;

import java.util.Scanner;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 3/31/21
 */
public class CourseController {

    public void getCoursesByTraineeId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Trainee Id: ");
        int traineeId = input.nextInt();
        TraineeValidator tv = new TraineeValidator();
        if (tv.isValidId(traineeId)) {
            CourseService courseService = new CourseService();
            Set<Course> courses = courseService.findAllByTraineeId(traineeId);
            courseService.processCourses(courses);
        } else {
            System.out.println("\n************************** Invalid Trainee Id *************************");
        }
    }

    public void getAllCourses() {
        CourseService courseService = new CourseService();
        Set<Course> courses = courseService.findAll();
        courseService.processCourses(courses);
    }

    public void processSave() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course Title: ");
        String courseTitle = input.nextLine();
        CourseValidator courseValidator = new CourseValidator();
        if (courseValidator.isValidName(courseTitle)) {
            Course course = new Course();
            course.setTitle(courseTitle);
            CourseService courseService = new CourseService();
            courseService.save(course);
        } else {
            System.out.println("Not a valid Name ");
        }
    }

    public void processUpdate() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new Course Name: ");
        String newName = input.nextLine();
        System.out.println("Enter Course id: ");
        int courseId = input.nextInt();

        CourseService courseService = new CourseService();
        Course course = new Course();
        course.setId(courseId);
        course.setTitle(newName);
        courseService.saveOrUpdate(course);

    }

    public void processRemove() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course id: ");
        int courseId = input.nextInt();
        CourseService courseService = new CourseService();
        Course course = new Course();
        course.setId(courseId);
        courseService.remove(course);
    }
}
