package net.therap.service;

import net.therap.dao.TraineeDao;
import net.therap.model.Trainee;
import net.therap.view.TraineesView;

import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/8/21
 */
public class TraineeService {

    public void processTrainees(Set<Trainee> trainees) {
        TraineesView traineesView = new TraineesView();
        traineesView.view(trainees);
    }

    public Set<Trainee> getTrainees(int courseId) {
        TraineeDao traineeDao = new TraineeDao();
        Set<Trainee> trainees = traineeDao.findAllByCourseId(courseId);

        return trainees;
    }

    public Set<Trainee> getAll() {
        TraineeDao traineeDao = new TraineeDao();
        Set<Trainee> trainees = traineeDao.findAll();
        return trainees;
    }

    public void insertTrainee(Trainee trainee) {
        TraineeDao traineeDao = new TraineeDao();
        traineeDao.insert(trainee);
    }

    public void updateTrainee(Trainee trainee) {
        TraineeDao traineeDao = new TraineeDao();
        traineeDao.update(trainee);
    }

    public void deleteTrainee(Trainee trainee) {
        TraineeDao traineeDao = new TraineeDao();
        traineeDao.delete(trainee);
    }
}
