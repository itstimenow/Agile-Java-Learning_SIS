package languageTest;

import java.util.logging.*;
import junit.framework.TestCase;


public class LoggingTest extends TestCase {
    
    public void testGetLogger() {
        Logger a = Logger.getLogger("sis.studentinfo.Student");
        Logger b = Logger.getLogger("sis.studentinfo.Student");
        assertEquals(a, b);
    }
    
    public void testLoggingHierarchy() {
        Logger logger = Logger.getLogger("sis.studentinfo.Student");
        Logger parent = Logger.getLogger("sis.studentinfo");
        assertEquals(parent, logger.getParent());
        assertEquals(Logger.getLogger("sis"), parent.getParent());
    }
}
