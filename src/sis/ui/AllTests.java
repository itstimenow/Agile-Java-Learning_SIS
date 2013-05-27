package sis.ui;

import junit.framework.*;


public class AllTests {
    
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(StudentUITest.class);
        return suite;
    }
    
}
