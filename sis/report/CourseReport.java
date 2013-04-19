package sis.report;

import java.util.*;
import sis.studentinfo.CourseSession;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReport {
    private ArrayList<CourseSession> sessions = new ArrayList<CourseSession>();
    
    public void add(CourseSession session) {
        sessions.add(session);
    }
    
    public String text() {
        Collections.sort(sessions);
        
        StringBuilder builder = new StringBuilder();
        for (CourseSession session : sessions)
            builder.append(session.getDepartment() + " " 
                           + session.getNumber() + NEWLINE);
        return builder.toString();
    }
}
