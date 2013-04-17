package sis.report;

import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(ReportConstantTest.class);
        return suite;
    }
}
