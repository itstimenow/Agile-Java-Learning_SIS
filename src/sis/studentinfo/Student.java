package sis.studentinfo;

import java.util.*;

public class Student {
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
    
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";
    
    private String name;
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private int credits = 0;
    private String state = "";
    private List<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    private List<Integer> charges = new ArrayList<Integer>();
    
    
    public Student(String fullName) {
        this.name = fullName;
        List<String> nameParts = split(fullName);
        setName(nameParts);
    }
    
    
    private List<String> split(String fullName) {
        List<String> results = new ArrayList<String>();
        for (String name : fullName.split(" "))
            results.add(name);
        return results;
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
        if (grades.isEmpty())
            return 0.0;
        
        double total = 0.0;
        for (Grade grade : grades)
            total += gradingStrategy.getGradePointsFor(grade);
        
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
}
