package net.therap;

import net.therap.controller.CourseController;
import net.therap.controller.CourseEnrollmentController;
import net.therap.controller.TraineeController;
import net.therap.view.StartingOptionsView;

import java.util.Scanner;

import static net.therap.util.InputType.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StartingOptionsView.viewOptions();
        while (input.hasNext()) {
            int choice = input.nextInt();
            switch (choice) {
                case COURSES_DETAILS_BY_TRAINEEID:
                    System.out.println("COURSE_DETAILS_BY_TRAINEEID");
                    CourseController courseDetails = new CourseController();
                    courseDetails.getCoursesByTraineeId();
                    break;
                case TRAINEES_DETAILS_BY_COURSEID:
                    System.out.println("TRAINEES_DETAILS_BY_COURSEID");
                    TraineeController traineesForCourse = new TraineeController();
                    traineesForCourse.getTraineesByCourseId();
                    break;
                case ADD_NEW_COURSE:
                    CourseController courseAdd = new CourseController();
                    courseAdd.processSave();
                    break;
                case ADD_NEW_TRAINEE:
                    TraineeController traineeAdd = new TraineeController();
                    traineeAdd.processSave();
                    break;
                case ENROLL_NEW_TRAINEES:
                    System.out.println("ENROLL_NEW_TRAINEES");
                    CourseEnrollmentController enrollTrainees = new CourseEnrollmentController();
                    enrollTrainees.enrollTraineeByCourseId();
                    break;
                case REMOVE_TRAINEE_FROM_COURSE:
                    System.out.println("REMOVE_TRAINEE_FROM_COURSE");
                    CourseEnrollmentController deleteCourseEnrollment = new CourseEnrollmentController();
                    deleteCourseEnrollment.removeTraineeByCourseId();
                    break;
                case UPDATE_TRAINEE_EMAIL:
                    System.out.println("UPDATE_TRAINEE_EMAIL");
                    TraineeController traineeUpdate1 = new TraineeController();
                    traineeUpdate1.processUpdateTraineeEmail();
                    break;
                case UPDATE_TRAINEE_NAME:
                    System.out.println("UPDATE_TRAINEE_NAME");
                    TraineeController traineeUpdate2 = new TraineeController();
                    traineeUpdate2.processUpdateTraineeName();
                    break;
                case UPDATE_COURSE_TITLE:
                    System.out.println("UPDATE_COURSE_TITLE");
                    CourseController courseUpdate = new CourseController();
                    courseUpdate.processUpdate();
                    break;
                case DELETE_TRAINEE:
                    System.out.println("DELETE_TRAINEE");
                    TraineeController traineeDelete = new TraineeController();
                    traineeDelete.processRemove();
                    break;
                case DELETE_COURSE:
                    System.out.println("DELETE_COURSE");
                    CourseController courseDelete = new CourseController();
                    courseDelete.processRemove();
                    break;
                case GET_ALL_COURSES:
                    System.out.println("GET_ALL_COURSES");
                    CourseController allCourses = new CourseController();
                    allCourses.getAllCourses();
                    break;
                case GET_ALL_TRAINEES:
                    System.out.println("GET_ALL_TRAINEES");
                    TraineeController allTrainees = new TraineeController();
                    allTrainees.getAllTrainees();
                    break;
                case EXIT:
                    System.out.printf("EXIT");
                    System.exit(0);
            }
            StartingOptionsView.viewOptions();
            ;
        }
    }
}
