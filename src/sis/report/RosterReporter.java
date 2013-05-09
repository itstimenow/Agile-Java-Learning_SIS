package sis.report;

import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

class RosterReporter {
    
    private Session session;
    
    static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + 
        "--" + NEWLINE;
    static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";

    
    RosterReporter(Session session) {
        this.session = session;
    }
    
    String getReport() {
        StringBuilder buffer = new StringBuilder();
        writeHeader(buffer);
        writeBody(buffer);
        writeFooter(buffer);
        return buffer.toString();
    }
    
    private void writeHeader(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_HEADER);
    }
    
    private void writeBody(StringBuilder buffer) {
        for (Student student : session.getAllStudents())
            buffer.append(student.getName() + NEWLINE);
    }
    
    private void writeFooter(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_FOOTER + 
            session.getNumberOfStudents() + NEWLINE);
    }
}
