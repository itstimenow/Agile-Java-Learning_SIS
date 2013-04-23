package sis.studentinfo;

public class HonorsGradingStrategy extends BasicGradingStrategy {
    public int getGradePointsFor(Student.Grade grade) {
        int points = basicGradePointsFor(grade);
        if (points > 0)
            points += 1;
        return points;
    }
}
