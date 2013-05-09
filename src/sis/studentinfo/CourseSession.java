package sis.studentinfo;

import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Administrator
 */
public class CourseSession extends Session {
    
    private static int count = 0;
    
    
    private CourseSession(Course course, Date startDate) {
        super(course, startDate);
    }
    
    
    public static Session create(Course course, Date startDate) {
        incrementCount();
        return new CourseSession(course, startDate);
    }
    
    static void resetCount() {
        count = 0;
    }
    
    static int getCount() {
        return count;
    }
    
    private static void incrementCount() {
        ++count;
    }
    
    /**
     * @return The number of weeks
     */
    @Override
    protected int getSessionLength() {
        return 16;
    }
}
