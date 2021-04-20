package net.therap.service;

import net.therap.dao.CourseEnrollmentDao;

import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/18/21
 */
public class CourseEnrollmentService {

    public void enrollTrainees(int courseId, Set<Integer> traineeIds) {
        CourseEnrollmentDao ced = new CourseEnrollmentDao();
        ced.addTraineeList(courseId, traineeIds);
    }

    public void removeTrainee(int courseId, int traineeId) {
        CourseEnrollmentDao ced = new CourseEnrollmentDao();
        ced.removeTrainee(courseId, traineeId);
    }
}
