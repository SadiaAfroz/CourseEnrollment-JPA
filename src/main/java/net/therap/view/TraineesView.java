package net.therap.view;

import net.therap.model.Trainee;

import java.util.List;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/12/21
 */
public class TraineesView implements DetailsView<Trainee> {

    @Override
    public void view(Set<Trainee> trainees) {
        System.out.println("");
        for (Trainee trainee : trainees) {
            System.out.println(trainee.toString());
        }
    }
}