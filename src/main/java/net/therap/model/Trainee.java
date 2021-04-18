package net.therap.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TRAINEE")
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;

    @ManyToMany(mappedBy = "trainees")
    Set<Course> courses ;

    public Trainee(){
        this.courses=new HashSet<>();
    }

    public Trainee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courses=new HashSet<>();
    }

    public Trainee(String name, String email) {
        this.name = name;
        this.email = email;
        this.courses=new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        boolean added= courses.add(course);
        if(added){
            course.getTrainees().add(this);
        }
    }

    public void removeCourse(Course course){
        boolean removed= courses.remove(course);
        if(removed){
            course.getTrainees().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
