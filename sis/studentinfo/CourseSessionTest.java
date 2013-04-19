package sis.studentinfo;

import java.util.*;
import junit.framework.TestCase;

public class CourseSessionTest extends TestCase {
    private static final int CREDITS = 3;
    private CourseSession session;
    private Date startDate;
    
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createCourseSession();
    }
        
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }
    
    public void testEnrollStudents() {        
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        
        List<Student> students = session.getAllStudents();
        assertEquals(1, students.size());
        assertEquals(student1, students.get(0));
        
        
        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }
    
    public void testCourseDates() {
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }
    
    public void testCount() {
        CourseSession.resetCount();
        createCourseSession();
        assertEquals(1, CourseSession.getCount());
        createCourseSession();
        assertEquals(2, CourseSession.getCount());
    }
    
    public void testComparable() {
        final Date date = new Date();
        CourseSession sessionA = CourseSession.create("CMSC", "101", date);
        CourseSession sessionB = CourseSession.create("ENGL", "101", date);        
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
        
        CourseSession sessionC = CourseSession.create("CMSC", "101", date);        
        assertEquals(0, sessionA.compareTo(sessionC));
        assertEquals(0, sessionC.compareTo(sessionA));
        
        CourseSession sessionD = CourseSession.create("CMSC", "210", date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);
    }
    
    private CourseSession createCourseSession() {
        CourseSession session = CourseSession.create("ENGL", "101", startDate);
        session.setNumberOfCredits(CREDITS);
        return session;
    }
}
