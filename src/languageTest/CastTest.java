package languageTest;

import junit.framework.TestCase;


public class CastTest extends TestCase {
    
    public void testAutoboxing() {
        Integer x = 5;
        assertEquals(5, x.intValue());
    }
    
    public void testAutoUnboxing() {
        int x = new Integer(5);
        assertEquals(5, x);
    }
    
    public void testAutoUnboxingMath() {
        assertEquals(10, new Integer(2) * new Integer(5));
    }
}
