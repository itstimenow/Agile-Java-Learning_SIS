package sis.report;

import java.util.*;
import junit.framework.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReportTest extends TestCase {
    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(createSession("ENGL", "101", date));
        report.add(createSession("CZEC", "200", date));
        report.add(createSession("ITAL", "410", date));
        report.add(createSession("CZEC", "220", date));
        report.add(createSession("ITAL", "330", date));
        
        assertEquals(String.format(  "CZEC 200%n"
                                   + "CZEC 220%n"
                                   + "ENGL 101%n"
                                   + "ITAL 330%n"
                                   + "ITAL 410%n"), 
                     report.text());
    }
    
    private Session createSession(String department, String number, Date date) {
        Course course = new Course(department, number);
        return CourseSession.create(course, date);
    }
}
