package net.therap.validator;

import net.therap.dao.CourseEnrollmentDao;

public class EnrollmentValidator {
    CourseEnrollmentDao courseEnrollmentDao;

    public EnrollmentValidator() {
        this.courseEnrollmentDao = new CourseEnrollmentDao();
    }

}
