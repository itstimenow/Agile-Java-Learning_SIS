package sis.studentinfo;

import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Administrator
 */
public class CourseSession implements Comparable<CourseSession> {
    private static int count = 0;
    
    private String department;
    private String number;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;
    private int numberOfCredits;
    
    
    protected CourseSession(String department, String number, Date startDate) {
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
    
    public int compareTo(CourseSession that) {
        int compare = this.getDepartment().compareTo(that.getDepartment());
        if (compare == 0)
            compare = this.getNumber().compareTo(that.getNumber());
        
        return compare;
    }
    
    
    public String getDepartment() {
        return department;
    }
    
    public String getNumber() {
        return number;
    }
    
    protected Date getStartDate() {
        return startDate;
    }
    
    public int getNumberOfStudents() {
        return students.size();
    }
    
    public List<Student> getAllStudents() {
        return students;
    }
    
    public void enroll(Student student) {
        students.add(student);
        student.addCredits(numberOfCredits);
    }
    
    Student get(int index) {
        return students.get(index);
    }
    
    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        
        // the number of weeks
        int sessionLength = getSessionLength();
        int daysPerWeek = 7;
        // The last Saturday and Sunday are not included in the session
        int daysToReduce = 2;
        int numberOfDays = sessionLength * daysPerWeek - daysToReduce;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays - 1);
        return calendar.getTime();
    }
    
    /**
     * @return Number of weeks
     */
    protected int getSessionLength() {
        return 16;
    }
    
    void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
}
