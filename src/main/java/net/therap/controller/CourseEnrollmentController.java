package net.therap.controller;

import net.therap.service.CourseEnrollmentService;
import net.therap.validator.CourseValidator;
import net.therap.validator.EnrollmentValidator;
import net.therap.validator.TraineeValidator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/12/21
 */
public class CourseEnrollmentController {

    public void enrollTraineeByCourseId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course Id: ");
        int courseId = input.nextInt();

        CourseValidator cv = new CourseValidator();
        if (cv.isValidId(courseId)) {
            System.out.println("How many Trainee Id's you will add ? ");
            int numberOfTrainees = input.nextInt();

            TraineeValidator traineeValidator = new TraineeValidator();
            if (traineeValidator.hasTraineeCapacity(courseId, numberOfTrainees)) {
                System.out.println("Enter Trainee ids:");
                Set<Integer> traineeIds = new HashSet<>();
                int cnt = 0;
                while (cnt < numberOfTrainees) {
                    int traineeId = input.nextInt();
                    TraineeValidator tv = new TraineeValidator();
                    if (tv.isValidId(traineeId)) {
                        traineeIds.add(traineeId);
                    } else {
                        System.out.println("\n************************* Invalid Trainee Id ***************************");
                    }
                    System.out.println("Enter Next Trainee id : ");
                    cnt++;
                }
                CourseEnrollmentService ces = new CourseEnrollmentService();
                ces.enrollTrainees(courseId, traineeIds);
            } else {
                System.out.println("*************************** Capacity Not Supported **********************");
            }
        } else {
            System.out.println("\n************************* Invalid Course Id ********************");
        }
    }

    public void removeTraineeByCourseId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course Id: ");
        int courseId = input.nextInt();

        CourseValidator cv = new CourseValidator();
        if (cv.isValidId(courseId)) {
            System.out.println("Enter Trainee id:");
            int traineeId = input.nextInt();
            TraineeValidator tv = new TraineeValidator();
            if (tv.isValidId(traineeId)) {
                EnrollmentValidator ev = new EnrollmentValidator();
                //remove
                CourseEnrollmentService ces = new CourseEnrollmentService();
                ces.removeTrainee(courseId, traineeId);
            } else {
                System.out.println("\n************************* Invalid Trainee Id ***************************");
            }

        } else {
            System.out.println("\n************************* Invalid Course Id ********************");
        }
    }
}
