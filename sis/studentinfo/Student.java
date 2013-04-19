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
        for (String grade : grades) {
            if (grade.equals("A"))
                total += 4;
            else if (grade.equals("B"))
                total += 3;
            else if (grade.equals("C"))
                total += 2;
            else if (grade.equals("D"))
                total += 1;
        }
        
        return total / grades.size();
    }
}
