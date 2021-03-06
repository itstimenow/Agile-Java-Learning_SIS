package sis.studentinfo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.net.MalformedURLException;
import junit.framework.TestCase;


public abstract class SessionTest extends TestCase {
    
    private Session session;
    private Date startDate;
    public static final int CREDITS = 3;
    
    @Override
    public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createSession(new Course("ENGL", "101"), startDate);
        session.setNumberOfCredits(CREDITS);
    }
    
    protected abstract Session createSession(Course course, Date startDate);
    
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(startDate, session.getStartDate());
        assertEquals(CREDITS, session.getNumberOfCredits());
        assertEquals(0, session.getNumberOfStudents());
    }
    
    public void testEnrollStudents() {
        Student student1 = new Student("Cain DiVoe");
        session.enroll(student1);
        assertEquals(CREDITS, student1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        
        Student student2 = new Student("Coralee DeVaughn");
        session.enroll(student2);
        assertEquals(CREDITS, student2.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }
    
    public void testComparable() {
        final Date date = new Date();
        Session sessionA = createSession(new Course("CMSC", "101"), date);
        Session sessionB = createSession(new Course("ENGL", "101"), date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
        
        Session sessionC = createSession(new Course("CMSC", "101"), date);
        assertEquals(0, sessionA.compareTo(sessionC));
        
        Session sessionD = createSession(new Course("CMSC", "210"), date);
        assertTrue(sessionC.compareTo(sessionD) < 0);
        assertTrue(sessionD.compareTo(sessionC) > 0);
    }
    
    public void testSessionLength() {
        Session session = createSession(new Course("", ""), new Date());
        assertTrue(session.getSessionLength() > 0);
    }
    
    public void testAverageGpaForPartTimeStudents() {
        session.enroll(createFullTimeStudent());
        
        Student partTimeStudent01 = new Student("1");
        partTimeStudent01.addGrade(Student.Grade.A);
        session.enroll(partTimeStudent01);
        
        session.enroll(createFullTimeStudent());
        
        Student partTimeStudent02 = new Student("2");
        partTimeStudent02.addGrade(Student.Grade.B);
        session.enroll(partTimeStudent02);
        
        assertEquals(3.5, session.averageGpaForPartTimeStudents(), 0.05);
    }
    
    private Student createFullTimeStudent() {
        Student student = new Student("a");
        student.addCredits(Student.CREDITS_REQUIRED_FOR_FULL_TIME);
        return student;
    }
    
    public void testIterate() {
        enrollStudents(session);
        
        List<Student> results = new ArrayList<Student>();
        for (Student student : session)
            results.add(student);
        
        assertEquals(session.getAllStudents(), results);
    }
    
    private void enrollStudents(Session session) {
        session.enroll(new Student("1"));
        session.enroll(new Student("2"));
        session.enroll(new Student("3"));
    }
    
    public void testSessionUrl() throws SessionException {
        final String url = "http://course.langrsoft.com/cmsc300";
        session.setUrl(url);
        assertEquals(url, session.getUrl().toString());
    }
    
    public void testInvalidSessionUrl() {
        final String url = "httsp://course.langrsoft.com/cmsc300";
        try {
            session.setUrl(url);
            fail("expected exception due to invalid protocol in URL");
        }
        catch (SessionException expectedException) {
            Throwable cause = expectedException.getCause();
            assertTrue(cause instanceof MalformedURLException);
        }
    }
}
