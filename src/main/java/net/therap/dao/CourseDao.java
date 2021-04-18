package net.therap.dao;

import net.therap.model.Course;
import net.therap.model.Trainee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/8/21
 */
public class CourseDao {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public CourseDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("courseEnrollment");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public Course findById(int courseId) {
        String sql = "SELECT title FROM Course WHERE id=:courseId";
        Course course = new Course();
        Query query = entityManager.createQuery(sql);

        String courseTitle = ((String) query.setParameter("courseId", courseId).getSingleResult());
        course.setId(courseId);
        course.setTitle(courseTitle);

        entityManager.close();
        entityManagerFactory.close();
        return course;
    }

    public Set<Course> findAllByTraineeId(int traineeId) {
        Set<Course> courses = new HashSet<>();
        Trainee trainee = (Trainee) entityManager.find(Trainee.class, traineeId);
        courses.addAll(trainee.getCourses());
        return courses;
    }

    public Set<Course> findAll() {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> results = query.getResultList();
        Set<Course> courses = new HashSet<>(results);

        return courses;
    }

    public int checkNameExist(String courseTitle) {
        String sql = "SELECT COUNT(*) as count FROM Course WHERE title = :title";
        Query query = entityManager.createQuery(sql);

        int count = ((Long) query.setParameter("title", courseTitle).getSingleResult()).intValue();

        entityManager.close();
        entityManagerFactory.close();

        return count;
    }


    public int checkIdExist(int id) {
        String sql = "SELECT COUNT(*) as count FROM Course WHERE id = :id";
        Query query = entityManager.createQuery(sql);

        int count = ((Long) query.setParameter("id", id).getSingleResult()).intValue();

        entityManager.close();
        entityManagerFactory.close();

        return count;
    }

    public void insert(Course course) {

        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Course Added");

    }

    public void update(Course course) {

        Course c = entityManager.find(Course.class, course.getId());

        if (c != null) {
            entityManager.getTransaction().begin();
            c.setTitle(course.getTitle());
            entityManager.getTransaction().commit();
            System.out.println("Course Updated");
        } else {
            System.out.println("Invalid Course Id");
        }
        entityManager.close();
        entityManagerFactory.close();

    }

    public void delete(Course course) {
        Course c = entityManager.find(Course.class, course.getId());
        if (c != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(c);
            entityManager.getTransaction().commit();
            System.out.println("Course Deleted");
        } else {
            System.out.println("Invalid Course Id");
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
