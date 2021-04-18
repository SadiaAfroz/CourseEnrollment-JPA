package net.therap.dao;

import net.therap.model.Course;
import net.therap.model.Trainee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/8/21
 */
public class TraineeDao {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public TraineeDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("courseEnrollment");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public Set<Trainee> findAllByCourseId(int courseId) {
        Set<Trainee> trainees = new HashSet<>();
        Course course= (Course) entityManager.find(Course.class, courseId);
        trainees.addAll(course.getTrainees());
        return trainees;
    }

    public int findByName(String name) {
        String sql = "SELECT id from Trainee WHERE name=:name";
        int traineeId = -1;

        Query query = entityManager.createQuery(sql);

        traineeId = ((Long) query.setParameter("name", name).getSingleResult()).intValue();

        entityManager.close();
        entityManagerFactory.close();

        return traineeId;
    }


    public Set<Trainee> findAll() {
        TypedQuery<Trainee> query = entityManager.createQuery("SELECT t FROM Trainee t", Trainee.class);
        List<Trainee> results = query.getResultList();
        Set<Trainee> trainees=new HashSet<>(results);

        return trainees;
    }

    public int checkNameExist(String name) {
        String sql = "SELECT COUNT(*) as count FROM Trainee WHERE name=:name";
        int count = 0;
        Query query = entityManager.createQuery(sql);

        count = ((Long) query.setParameter("name", name).getSingleResult()).intValue();

        entityManager.close();
        entityManagerFactory.close();

        return count;
    }

    public int checkIdExist(int id) {
        String sql = "SELECT COUNT(*) as count FROM Trainee WHERE id=:id";
        int count = 0;
        Query query = entityManager.createQuery(sql);

        count = ((Long) query.setParameter("id", id).getSingleResult()).intValue();

        entityManager.close();
        entityManagerFactory.close();

        return count;
    }

    public void insert(Trainee trainee) {
        entityManager.getTransaction().begin();
        entityManager.persist(trainee);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Trainee Added");
    }

    public void update(Trainee trainee){
        Trainee t = entityManager.find(Trainee.class, trainee.getId());

        if (t != null) {
            entityManager.getTransaction().begin();
            if(trainee.getName()!=null) {
                t.setName(trainee.getName());
            }
            if(trainee.getEmail()!=null) {
                t.setEmail(trainee.getEmail());
            }
            entityManager.getTransaction().commit();
            System.out.println("Trainee Name Updated");
        } else {
            System.out.println("Invalid Trainee Id");
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    public void delete(Trainee trainee) {
        Trainee t= entityManager.find(Trainee.class, trainee.getId());
        if (t != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
            System.out.println("Trainee Deleted");
        } else {
            System.out.println("Invalid Trainee Id");
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
