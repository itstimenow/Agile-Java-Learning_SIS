package languageTest;

import junit.framework.*;


public class NumericWrapperClassTest extends TestCase {
    
    public void testIntToString() {
        assertEquals("5", Integer.toString(5));
        assertEquals("101", Integer.toBinaryString(5));
        assertEquals("32", Integer.toHexString(50));
        assertEquals("21", Integer.toOctalString(17));
        
        assertEquals("21", Integer.toString(17, 8));
    }
    
    public void testStringToInt() {
        assertEquals(5, Integer.parseInt("5"));
        
        assertEquals(10, Integer.decode("10").intValue());
        assertEquals(16, Integer.decode("0x10").intValue());
        assertEquals(16, Integer.decode("0X10").intValue());
        assertEquals(16, Integer.decode("#10").intValue());
        assertEquals(8, Integer.decode("010").intValue());
        assertEquals(-10, Integer.decode("-10").intValue());
        assertEquals(-16, Integer.decode("-0x10").intValue());
    }
}
