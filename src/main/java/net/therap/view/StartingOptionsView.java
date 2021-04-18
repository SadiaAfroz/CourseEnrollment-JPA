package net.therap.view;

/**
 * @author sadia.afroz
 * @since 4/12/21
 */
public class StartingOptionsView {

    public static void viewOptions() {
        System.out.println();
        System.out.println("Choose the option :");
        System.out.println("1. Get courses details by trainee id : (trainee id)");
        System.out.println("2. Get trainess details by course id : (course id)");
        System.out.println("3. Add new course (course name)");
        System.out.println("4. Add new trainee (trainee name)");
        System.out.println("5. Enroll new Trainees(course id, trainee ids)");
        System.out.println("6. Enroll new Courses(trainee id, course ids)");
        System.out.println("7. Remove trainee from course (course id, trainee id)");
        System.out.println("8. Update trainee email (trainee new email, trainee id)");
        System.out.println("9. Update trainee name (trainee new name, trainee id)");
        System.out.println("10. Update course title (course new title, course id)");
        System.out.println("11. Delete trainee  (trainee id)");
        System.out.println("12. Delete course (courseid)");
        System.out.println("13. Get All Courses");
        System.out.println("14. Get All Trainees");
        System.out.println("15. EXIT ");
    }
}
