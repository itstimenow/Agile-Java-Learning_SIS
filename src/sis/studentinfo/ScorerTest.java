package sis.studentinfo;

import junit.framework.TestCase;


public class ScorerTest extends TestCase {
    
    public void testCaptureScore() {
        Scorer scorer = new Scorer();
        assertEquals(75, scorer.score("75"));
    }
    
    public void testBadScoreInputed() {
        Scorer scorer = new Scorer();
        try {
            scorer.score("abd");
            fail("expected NumberFormatException on bad input");
        }
        catch(NumberFormatException success) {
        }
    }
}
