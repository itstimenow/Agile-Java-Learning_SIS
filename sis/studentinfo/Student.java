package sis.studentinfo;

import java.util.ArrayList;

public class Student {
    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";
    
    private String name;
    private int credits = 0;
    private String state = "";
    private ArrayList<String> grades = new ArrayList<String>();
    
    public Student(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }
    
    int getCredits() {
        return credits;
    }
    
    void addCredits(int credits) {
        this.credits += credits;
    }
    
    void setState(String state) {
        this.state = state.toUpperCase();
    }
    
    boolean isInState() {
        return state.equals(Student.IN_STATE);
    }
    
    void addGrade(String grade) {
        grades.add(grade);
    }
    
    double getGpa() {
        if (grades.isEmpty())
            return 0.0;
        
        double total = 0.0;
        for (String grade : grades)
            total += gradePointFor(grade);
        
        return total / grades.size();
    }
    
    private double gradePointFor(String grade) {
        if (grade.equals("A")) return 4.0;
        if (grade.equals("B")) return 3.0;
        if (grade.equals("C")) return 2.0;
        if (grade.equals("D")) return 1.0;
        return 0.0;
    }
}
