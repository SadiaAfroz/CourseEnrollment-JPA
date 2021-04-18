package net.therap.view;

import net.therap.model.Course;

import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/12/21
 */
public class CoursesView implements DetailsView<Course> {

    @Override
    public void view(Set<Course> courses) {
        System.out.println("");
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }
}