package net.therap.controller;

import net.therap.model.Trainee;
import net.therap.service.TraineeService;
import net.therap.validator.CourseValidator;
import net.therap.validator.TraineeValidator;

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

        CourseValidator cv = new CourseValidator();
        if (cv.isValidId(courseId)) {
            TraineeService traineeService = new TraineeService();
            Set<Trainee> trainees = traineeService.findAllByCourseId(courseId);
            traineeService.processTrainees(trainees);
        } else {
            System.out.println("\n************************** Invalid Course Id *************************");
        }
    }

    public void getAllTrainees() {
        TraineeService traineeService = new TraineeService();
        Set<Trainee> trainees = traineeService.findAll();
        traineeService.processTrainees(trainees);
    }

    public void processSave() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Trainee Name: ");
        String traineeName = input.nextLine();
        System.out.println("Enter Trainee Email: ");
        String traineeEmail = input.nextLine();
        TraineeValidator traineeValidator = new TraineeValidator();
        if (traineeValidator.isValidName(traineeName)) {
            Trainee trainee = new Trainee();
            trainee.setName(traineeName);
            trainee.setEmail(traineeEmail);

            TraineeService traineeService = new TraineeService();
            traineeService.save(trainee);
        } else {
            System.out.println("Not a valid Trainee Name ");
        }
    }

    public void processUpdateTraineeName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new Trainee Name: ");
        String newName = input.nextLine();
        System.out.println("Enter Trainee id: ");
        int traineeId = input.nextInt();

        TraineeService traineeService = new TraineeService();
        Trainee trainee = new Trainee();
        trainee.setId(traineeId);
        trainee.setName(newName);
        traineeService.saveOrUpdate(trainee);
    }

    public void processUpdateTraineeEmail() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new Trainee Email: ");
        String newEmail = input.nextLine();
        System.out.println("Enter Trainee id: ");
        int traineeId = input.nextInt();

        TraineeService traineeService = new TraineeService();
        Trainee trainee = new Trainee();
        trainee.setId(traineeId);
        trainee.setEmail(newEmail);
        traineeService.saveOrUpdate(trainee);
    }

    public void processRemove() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Trainee id: ");
        int traineeId = input.nextInt();

        TraineeService traineeService = new TraineeService();
        Trainee trainee = new Trainee();
        trainee.setId(traineeId);
        traineeService.remove(trainee);
    }
}
