package sis.studentinfo;

import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Administrator
 */
public class CourseSession {
    private static int count = 0;
    
    private String department;
    private String number;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Date startDate;
    private int numberOfCredits;
    
    
    
    private CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }
    
    
    
    public static CourseSession create(
            String department, String number, Date startDate) {
        incrementCount();
        return new CourseSession(department, number, startDate);
    }
    
    static void resetCount() {
        count = 0;
    }
    
    static int getCount() {
        return count;
    }
    
    private static void incrementCount() {
        ++count;
    }
    
    
    
    String getDepartment() {
        return department;
    }
    
    String getNumber() {
        return number;
    }
    
    public int getNumberOfStudents() {
        return students.size();
    }
    
    public ArrayList<Student> getAllStudents() {
        return students;
    }
    
    public void enroll(Student student) {
        students.add(student);
        student.addCredits(numberOfCredits);
    }
    
    Student get(int index) {
        return students.get(index);
    }
    
    Date getStartDate() {
        return startDate;
    }
    
    Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        
        // The course session lasts 16 weeks, and each week has 7 days, so it 
        // seems that total number of days for the session is 16 * 7. But, 
        // wait, the last day of the session is the last Friday of the last 
        // week, both the last Saturday and Sunday are not during the session, 
        // so the total number of days for the session is 16 * 7 - 2.
        //
        // Also note that the start date is the first day of session, so the 
        // end date is [total-number-of-days-for-the-session - 1] days after 
        // the start date.
        int numberOfDays = 16 * 7 - 2 - 1;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
    
    void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
}
