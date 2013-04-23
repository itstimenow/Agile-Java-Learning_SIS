package sis.report;

import junit.framework.TestCase;

public class ReportConstantTest extends TestCase {
    public void testConstant() {
        String newline = System.getProperty("line.separator");
        assertEquals(newline, ReportConstant.NEWLINE);
    }
}
