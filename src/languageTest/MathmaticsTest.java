package languageTest;

import junit.framework.*;


public class MathmaticsTest extends TestCase {
    
    public void testNaN() {
        assertFalse(Double.NaN > 1.0);
        assertFalse(Double.NaN < 1.0);
        assertFalse(Double.NaN == 1.0);
        assertFalse(1.0 > Double.NaN);
        assertFalse(1.0 < Double.NaN);
        assertFalse(1.0 == Double.NaN);
    }
}
