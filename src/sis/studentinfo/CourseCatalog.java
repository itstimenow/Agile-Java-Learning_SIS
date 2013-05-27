package sis.studentinfo;

import java.io.*;
import java.util.*;


public class CourseCatalog {
    
    private List<Session> sessions = new ArrayList<Session>();
    
    public void add(Session session) {
        sessions.add(session);
    }
    
    public void clearAll() {
        sessions.clear();
    }
    
    public List<Session> getSessions() {
        return sessions;
    }
    
    public void store(String filename) throws IOException {
        DataOutputStream output = null;
        
        try {
            output = new DataOutputStream(new FileOutputStream(filename));
            output.writeInt(sessions.size());
            
            for (Session session : sessions) {
                output.writeUTF(session.getDepartment());
                output.writeUTF(session.getNumber());
                output.writeLong(session.getStartDate().getTime());
                output.writeInt(session.getNumberOfCredits());
            }
        }
        finally {
            output.close();
        }
    }
    
    public void load(String filename) throws IOException {
        DataInputStream input = null;
        
        try {
            input = new DataInputStream(new FileInputStream(filename));
            int numberOfSessions = input.readInt();
            
            for (int i = 0; i < numberOfSessions; i++) {
                String department = input.readUTF();
                String number = input.readUTF();
                Date startDate = new Date(input.readLong());
                int credits = input.readInt();
                Course course = new Course(department, number);
                Session session = CourseSession.create(course, startDate);
                session.setNumberOfCredits(credits);
                sessions.add(session);
            }
        }
        finally {
            input.close();
        }
    }

}
