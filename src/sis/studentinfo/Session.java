package sis.studentinfo;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.net.URL;
import java.net.MalformedURLException;


public abstract class Session implements Comparable<Session>, Iterable<Student> {
    private String department;
    private String number;
    private List<Student> students = new ArrayList<Student>();
    private Date startDate;
    private int numberOfCredits;
    private URL url;
    
    protected Session(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }
    
    public int compareTo(Session that) {
        int compare = this.getDepartment().compareTo(that.getDepartment());
        if (compare == 0)
            compare = this.getNumber().compareTo(that.getNumber());
        
        return compare;
    }
    
    public Iterator<Student> iterator() {
        return students.iterator();
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
    
    public URL getUrl() {
        return url;
    }
    
    public void setUrl(String urlString) throws SessionException {
        try {
            this.url = new URL(urlString);
        }
        catch (MalformedURLException e) {
            log(e);
            throw new SessionException(e);
        }
    }
    
    private void log(Exception e) {
        //e.printStackTrace();
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
    
    protected abstract int getSessionLength();
    
    void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    
    public double averageGpaForPartTimeStudents() {
        double total = 0.0;
        int count = 0;
        for (Student student : students) {
            if (student.isFullTime())
                continue;
            total += student.getGpa();
            count++;
        }
        
        if (count == 0)
            return 0.0;
        return total / count;
    }
}
