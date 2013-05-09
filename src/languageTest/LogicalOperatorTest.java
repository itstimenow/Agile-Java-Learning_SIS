package languageTest;

import junit.framework.TestCase;


public class LogicalOperatorTest extends TestCase {

    public void testXor() {
        assertTrue(true ^ false);
        assertTrue(false ^ true);
        assertFalse(true ^ true);
        assertFalse(false ^ false);
    }
}
