package net.therap.controller;

import net.therap.model.Course;
import net.therap.model.Trainee;
import net.therap.service.CourseService;
import net.therap.service.TraineeService;
import net.therap.validator.CourseValidator;
import net.therap.validator.TraineeValidator;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/12/21
 */
public class TraineeController {

    public void getTraineesByCourseId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course Id: ");
        int courseId = input.nextInt();

        CourseValidator cv=new CourseValidator();
        if(cv.isValidId(courseId)){
            TraineeService traineeProcessor = new TraineeService();
            Set<Trainee> trainees = traineeProcessor.getTrainees(courseId);
            traineeProcessor.processTrainees(trainees);
        }
        else {
            System.out.println("\n************************** Invalid Course Id *************************");
        }
    }

    public void getAllTrainees(){
        TraineeService traineeProcessor = new TraineeService();
        Set<Trainee> trainees = traineeProcessor.getAll();
        traineeProcessor.processTrainees(trainees);
    }



    public void insertTrainee() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Trainee Name: ");
        String traineeName = input.nextLine();
        System.out.println("Enter Trainee Email: ");
        String traineeemail = input.nextLine();
        TraineeValidator traineeValidator = new TraineeValidator();
        if (traineeValidator.isValidName(traineeName)) {
            Trainee trainee = new Trainee();
            trainee.setName(traineeName);
            trainee.setEmail(traineeemail);

            TraineeService traineeService = new TraineeService();
            traineeService.insertTrainee(trainee);
        } else {
            System.out.println("Not a valid Trainee Name ");
        }
    }

    public void updateTraineeName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new Trainee Name: ");
        String newName= input.nextLine();
        System.out.println("Enter Trainee id: ");
        int traineeId= input.nextInt();

        TraineeService traineeService=new TraineeService();
        Trainee trainee= new Trainee();
        trainee.setId(traineeId);
        trainee.setName(newName);
        traineeService.updateTrainee(trainee);
    }

    public void updateTraineeEmail() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new Trainee Email: ");
        String newEmail= input.nextLine();
        System.out.println("Enter Trainee id: ");
        int traineeId= input.nextInt();

        TraineeService traineeService=new TraineeService();
        Trainee trainee= new Trainee();
        trainee.setId(traineeId);
        trainee.setEmail(newEmail);
        traineeService.updateTrainee(trainee);
    }
    public void deleteTrainee() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Trainee id: ");
        int traineeId= input.nextInt();

        TraineeService traineeService=new TraineeService();
        Trainee trainee= new Trainee();
        trainee.setId(traineeId);
        traineeService.deleteTrainee(trainee);
    }
}
