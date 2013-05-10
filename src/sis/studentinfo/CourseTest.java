package sis.studentinfo;

import junit.framework.TestCase;


public class CourseTest extends TestCase {
    
    public void testCreate() {
        Course course = new Course("CMSC", "120");
        assertEquals("CMSC", course.getDepartment());
        assertEquals("120", course.getNumber());
    }
    
    public void testEquality() {
        final String department = "NURS";
        final String number = "201";
        
        Course courseA = new Course(department, number);
        Course courseAPrime = new Course(department, number);
        assertEquals(courseA, courseAPrime);
        
        Course courseB = new Course("ARTH", "330");
        assertFalse(courseA.equals(courseB));
        
        // reflexivity
        assertEquals(courseA, courseA);
        
        // symmetry
        assertEquals(courseAPrime, courseA);
        
        // transitivity
        Course courseAPrime2 = new Course(department, number);
        assertEquals(courseAPrime, courseAPrime2);
        assertEquals(courseA, courseAPrime2);
        
        // consistency
        assertEquals(courseA, courseAPrime);
        assertFalse(courseA.equals(courseB));
        
        // comparison to null
        assertFalse(courseA.equals(null));
    }
}
