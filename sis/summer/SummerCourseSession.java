package sis.summer;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import sis.studentinfo.*;

public class SummerCourseSession extends CourseSession {
    public static SummerCourseSession create(
            String department, String number, Date startDate) {
        return new SummerCourseSession(department, number, startDate);
    }
    
    private SummerCourseSession(String department, String number, 
                                Date startDate) {
        super(department, number, startDate);
    }
    
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        
        int sessionLength = 8;  // 8 weeks
        int daysInWeek = 7;
        // 2 days to reduce:
        //   - last Saturday and Sunday, which are not included in the session
        int daysToReduce = 2;
        int numberOfDays = sessionLength * daysInWeek - daysToReduce;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays - 1);
        return calendar.getTime();
    }
}
