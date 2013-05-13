package sis.studentinfo;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.*;


public class Student {
    
    static final String TOO_MANY_NAME_PART_MSG = "Student name '%s' contains more than %d parts";
    static final int MAX_NAME_PARTS = 3;
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";
    static final Logger logger = Logger.getLogger(Student.class.getName());
    
    private String id;
    private String name;
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private int credits = 0;
    private String state = "";
    private int settings = 0x0;
    private List<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private List<Integer> charges = new ArrayList<Integer>();
    
    
    public Student(String fullName) {
        this.name = fullName;
        List<String> nameParts = split(fullName);
        if (nameParts.size() > Student.MAX_NAME_PARTS) {
            String message = String.format(Student.TOO_MANY_NAME_PART_MSG, 
                                           fullName, Student.MAX_NAME_PARTS);
            Student.logger.info(message);
            throw new StudentNameFormatException(message);
        }
        setName(nameParts);
    }
    
    
    private List<String> split(String fullName) {
        List<String> fixedSizedNameList = Arrays.asList(fullName.split(" "));
        
        // Methods such as add, remove can't be performed on a fixed-size list, thus reconstruct an 
        // list to support all these operations
        return new ArrayList<String>(fixedSizedNameList);
    }
    
    private void setName(List<String> nameParts) {
        this.lastName = removeLast(nameParts);
        String name = removeLast(nameParts);
        if (nameParts.isEmpty())
            this.firstName = name;
        else {
            this.middleName = name;
            this.firstName = removeLast(nameParts);
        }
    }
    
    private String removeLast(List<String> list) {
        if (list.isEmpty())
            return "";
        return list.remove(list.size() - 1);
    }
    
    public String getName() {
        return name;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getMiddleName() {
        return middleName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String value) {
        id = value;
    }
        
    int getCredits() {
        return credits;
    }
    
    void setState(String state) {
        this.state = state.toUpperCase();
    }
    
    boolean isInState() {
        return state.equals(Student.IN_STATE);
    }    
    
    boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }
    
    void addCredits(int credits) {
        this.credits += credits;
    }
    
    void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }
    
    void addGrade(Grade grade) {
        grades.add(grade);
    }
    
    double getGpa() {
        Student.logger.fine("begin getGpa " + System.currentTimeMillis());
        
        if (grades.isEmpty())
            return 0.0;
        
        double total = 0.0;
        for (Grade grade : grades)
            total += gradingStrategy.getGradePointsFor(grade);
        
        Student.logger.fine("end getGpad " + System.currentTimeMillis());
        return total / grades.size();
    }
    
    public void addCharge(int charge) {
        charges.add(new Integer(charge));
    }
    
    public int totalCharges() {
        int total = 0;
        for (int charge : charges)
            total += charge;
        return total;
    }
    
    public void set(Flag... flags) {
        for (Flag flag : flags) {
            settings |= flag.mask;
        }
    }
    
    public void unset(Flag flag) {
        settings &= ~flag.mask;
    }
    
    public boolean isOn(Flag flag) {
        return (settings & flag.mask) == flag.mask;
    }
    
    public boolean isOff(Flag flag) {
        return !isOn(flag);
    }
    
    
    //============================================
    // Inner types 
    //============================================
    
    public enum Grade {
        A(4), B(3), C(2), D(1), F(0);
        
        private int points;
        
        Grade(int points) {
            this.points = points;
        }
        
        int getPoints() {
            return points;
        }
    }
    
    public enum Flag {
        ON_CAMPUS(1),
        TAX_EXEMPT(2),
        MINOR(4),
        TROUBLEMAKER(8);
        
        private int mask;
        
        Flag(int mask) {
            this.mask = mask;
        }
    }
}
