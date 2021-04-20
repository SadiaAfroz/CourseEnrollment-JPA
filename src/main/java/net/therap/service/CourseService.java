package net.therap.service;

import net.therap.dao.CourseDao;
import net.therap.model.Course;
import net.therap.view.CoursesView;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/8/21
 */
public class CourseService {

    // processing of viewing single Course
    public void processCourse(Course course) {
        System.out.println(course.toString());
    }

    // processing of viewing list of Courses
    public void processCourses(Set<Course> courses) {
        CoursesView coursesView = new CoursesView();
        coursesView.view(courses);
    }

    public Set<Course> findAll() {
        CourseDao courseDao = new CourseDao();
        Set<Course> courses = new HashSet<>(courseDao.findAll());
        return courses;
    }

    public Set<Course> findAllByTraineeId(int traineeId) {
        CourseDao courseDao = new CourseDao();
        Set<Course> courses = courseDao.findAllByTraineeId(traineeId);

        return courses;
    }

    public void save(Course course) {
        CourseDao courseDao = new CourseDao();
        courseDao.save(course);
    }

    public void saveOrUpdate(Course course) {
        CourseDao courseDao = new CourseDao();
        courseDao.saveOrUpdate(course);
    }

    public void remove(Course course) {
        CourseDao courseDao = new CourseDao();
        courseDao.remove(course);
    }
}
