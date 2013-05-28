package sis.studentinfo;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.*;


public abstract class Session
        implements Comparable<Session>, Iterable<Student>, Serializable {
    
    private Course course;
    private transient List<Student> students = new ArrayList<Student>();
    private Date startDate;
    private int numberOfCredits;
    private URL url;
    
    protected Session(Course course, Date startDate) {
        this.course = course;
        this.startDate = startDate;
    }
    
    
    protected abstract int getSessionLength();
    
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
        return course.getDepartment();
    }
    
    public String getNumber() {
        return course.getNumber();
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
    
    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    
    public int getNumberOfCredits() {
        return numberOfCredits;
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
    
    private void writeObject(ObjectOutputStream output)
            throws IOException {
        output.defaultWriteObject();
        output.writeInt(students.size());
        for (Student student : students)
            output.writeObject(student.getLastName());
    }
    
    private void readObject(ObjectInputStream input) 
            throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        students = new ArrayList<Student>();
        int size = input.readInt();
        for (int i = 0; i < size; i++) {
            String lastName = (String)input.readObject();
            students.add(Student.findByLastName(lastName));
        }
    }
}
