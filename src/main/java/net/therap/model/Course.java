package net.therap.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/18/21
 */
@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "ENROLLMENT_PAIR",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "traineeId")
    )
    Set<Trainee> trainees;

    public Course() {
        this.trainees = new HashSet<>();
    }

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
        this.trainees = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(Set<Trainee> trainees) {
        this.trainees = trainees;
    }

    public void addTrainee(Trainee trainee) {
        boolean added = trainees.add(trainee);
        if (added) {
            trainee.getCourses().add(this);
        }
    }

    public void removeTrainee(Trainee trainee) {
        boolean removed = trainees.remove(trainee);
        if (removed) {
            trainee.getCourses().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
