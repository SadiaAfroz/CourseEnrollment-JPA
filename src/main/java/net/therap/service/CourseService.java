package net.therap.service;

import net.therap.dao.CourseDao;
import net.therap.model.Course;
import net.therap.view.CoursesView;

import java.util.List;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/8/21
 */
public class CourseService {

    public void processCourse(Course course) {
        System.out.println(course.toString());
    }

    public void processCourses(Set<Course> courses) {
        CoursesView coursesView = new CoursesView();
        coursesView.view(courses);

    }

    public Set<Course> getAll() {
        CourseDao courseDao = new CourseDao();
        Set<Course> courses = courseDao.findAll();
        return courses;
    }

    public Set<Course> getCourses(int traineeId) {
        CourseDao courseDao = new CourseDao();
        Set<Course> courses = courseDao.findAllByTraineeId(traineeId);

        return courses;
    }

    public void insertCourse(Course course) {
        CourseDao courseDao = new CourseDao();
        courseDao.insert(course);
    }

    public void updateCourse(Course course) {
        CourseDao courseDao = new CourseDao();
        courseDao.update(course);
    }

    public void deleteCourse(Course course) {
        CourseDao courseDao = new CourseDao();
        courseDao.delete(course);
    }
}
