package languageTest;

import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(SortTest.class);
        suite.addTestSuite(SuperClassTest.class);
        return suite;
    }
}
