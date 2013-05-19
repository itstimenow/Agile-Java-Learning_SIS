package sis.report;

import java.io.Writer;
import java.io.StringWriter;
import java.io.IOException;
import junit.framework.TestCase;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class RosterReporterTest extends TestCase {
    
    public void testRosterReport() throws IOException {
        Session session = CourseSession.create(new Course("ENGL", "101"), 
                                               DateUtil.createDate(2003, 1, 6));
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
        
        Writer writer = new StringWriter();
        new RosterReporter(session).writeReport(writer);
        String rosterReport = writer.toString();
        
        String expectedReport = String.format(RosterReporter.ROSTER_REPORT_HEADER
                                              + "A%n"
                                              + "B%n"
                                              + RosterReporter.ROSTER_REPORT_FOOTER,
                                              2);
        assertEquals(expectedReport, rosterReport);
    }
}
