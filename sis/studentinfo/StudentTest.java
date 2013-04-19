package sis.studentinfo;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
    private static final double GRADE_TOLERANCE = 0.05;
    
    public void testCreate() {
        final String firstStudentName = "Jane Doe";
        Student firstStudent = new Student(firstStudentName);
        assertEquals(firstStudentName, firstStudent.getName());
        
        final String secondStudentName = "Joe Blow";
        Student secondStudent = new Student(secondStudentName);
        assertEquals(secondStudentName, secondStudent.getName());
        
        assertEquals(firstStudentName, firstStudent.getName());
    }
    
    public void testStudentStatus() {
        Student student = new Student("a");
        assertEquals(0, student.getCredits());
        assertFalse(student.isFullTime());
        
        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());
        
        student.addCredits(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());
        
        student.addCredits(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, 
                     student.getCredits());
        assertTrue(student.isFullTime());
    }
    
    public void testInState() {
        Student student = new Student("a");
        assertFalse(student.isInState());
        
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        
        student.setState("MD");
        assertFalse(student.isInState());
        
        student.setState("co");
        assertTrue(student.isInState());
    }
    
    public void testCalculateGpa() {
        Student student = new Student("a");
        assertGpa(student, 0.0);
        student.addGrade("A");
        assertGpa(student, 4.0);
        student.addGrade("B");
        assertGpa(student, 3.5);
        student.addGrade("C");
        assertGpa(student, 3.0);
        student.addGrade("D");
        assertGpa(student, 2.5);
        student.addGrade("F");
        assertGpa(student, 2.0);
    }
    
    private void assertGpa(Student student, double expectedGpa) {
        assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
    }
}
