package sis.studentinfo;

import java.util.*;
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
        
        // comparison to null
        assertFalse(courseA.equals(null));
        
        // unequal
        Course courseB = new Course("ARTH", "330");
        assertFalse(courseA.equals(courseB));
        
        // apples & oranges
        assertFalse(courseA.equals("CMSC-120"));
    }
    
    public void testHashCode() {
        final String department = "NURS";
        final String number = "201";
        Course courseA = new Course(department, number);
        Course courseAPrime = new Course(department, number);
        
        assertEquals(courseA.hashCode(), courseAPrime.hashCode());
        // consistency
        assertEquals(courseA.hashCode(), courseA.hashCode());
    }
    
    public void testHashCodePerformance() {
        final int count = 10000;
        long start = System.currentTimeMillis();
        
        Set<Course> set = new HashSet<Course>();
        for (int i = 0; i < count; i++) {
            Course course = new Course("C" + i, "" + i);
            set.add(course);
        }
        
        long stop = System.currentTimeMillis();
        long elapsed = stop - start;
        
        final long arbitraryThreshold = 200;
        assertTrue("elapsed time = " + elapsed, 
                   elapsed < arbitraryThreshold);
    }
}
