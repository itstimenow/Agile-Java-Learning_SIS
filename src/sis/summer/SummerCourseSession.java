package sis.summer;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import sis.studentinfo.*;

public class SummerCourseSession extends Session {

    private SummerCourseSession(Course course, Date startDate) {
        super(course, startDate);
    }
    
    public static Session create(Course course, Date startDate) {
        return new SummerCourseSession(course, startDate);
    }
    
    @Override
    protected int getSessionLength() {
        return 8;
    }
}
