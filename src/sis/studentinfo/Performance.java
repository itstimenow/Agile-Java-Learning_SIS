package sis.studentinfo;


public class Performance {
    
    private int[] tests;
    
    public void setNumberOfTests(int numberOfTests) {
        tests = new int[numberOfTests];
    }
    
    public void set(int testIndex, int score) {
        tests[testIndex] = score;
    }
    
    public void setScores(int... tests) {
        this.tests = tests;
    }
    
    public int get(int testIndex) {
        return tests[testIndex];
    }
    
    public double average() {
        if (tests == null || tests.length == 0)
            return 0.0;
        
        double total = 0;
        for (int score : tests)
            total += score;
        return total / tests.length;
    }
}
