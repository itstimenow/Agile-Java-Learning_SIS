import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(sis.AllTests.suite());
        suite.addTest(languageTest.AllTests.suite());
        return suite;
    }
}
