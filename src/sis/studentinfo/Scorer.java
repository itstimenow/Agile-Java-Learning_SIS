package sis.studentinfo;


public class Scorer {
    
    public int score(String score) {
        return Integer.parseInt(score);
    }
    
    public boolean isValid(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
