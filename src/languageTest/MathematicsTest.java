package languageTest;

import junit.framework.*;


public class MathematicsTest extends TestCase {
    
    public void testNaN() {
        assertFalse(Double.NaN > 1.0);
        assertFalse(Double.NaN < 1.0);
        assertFalse(Double.NaN == 1.0);
        assertFalse(1.0 > Double.NaN);
        assertFalse(1.0 < Double.NaN);
        assertFalse(1.0 == Double.NaN);
        
        assertFalse(Float.NaN > 1.0);
        assertFalse(Float.NaN < 1.0);
        assertFalse(Float.NaN == 1.0);
        assertFalse(1.0 > Float.NaN);
        assertFalse(1.0 < Float.NaN);
        assertFalse(1.0 == Float.NaN);
    }
    
    public void testInfinity() {
        final float tolerance = 0.5F;
        final float x = 1F;
        
        assertEquals(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY * 100, tolerance);
        assertEquals(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY * -1, tolerance);
        
        assertEquals(Float.POSITIVE_INFINITY, x / 0f, tolerance);
        assertEquals(Float.NEGATIVE_INFINITY, x / -0f, tolerance);
        assertTrue(Float.isNaN(x % 0f));
        assertEquals(0f, x / Float.POSITIVE_INFINITY, tolerance);
        assertEquals(-0f, x / Float.NEGATIVE_INFINITY, tolerance);
        assertEquals(x, x % Float.POSITIVE_INFINITY, tolerance);
        assertTrue(Float.isNaN(0f / 0f));
        assertTrue(Float.isNaN(0f % 0f));
        assertEquals(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY / x, tolerance);
        assertEquals(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY / x, tolerance);
        assertTrue(Float.isNaN(Float.POSITIVE_INFINITY % x));
        assertTrue(Float.isNaN(Float.POSITIVE_INFINITY / Float.POSITIVE_INFINITY));
        assertTrue(Float.isNaN(Float.POSITIVE_INFINITY % Float.POSITIVE_INFINITY));
        assertTrue(Float.isNaN(Float.POSITIVE_INFINITY / Float.NEGATIVE_INFINITY));
        assertTrue(Float.isNaN(Float.POSITIVE_INFINITY % Float.NEGATIVE_INFINITY));
        assertTrue(Float.isNaN(Float.NEGATIVE_INFINITY / Float.POSITIVE_INFINITY));
        assertTrue(Float.isNaN(Float.NEGATIVE_INFINITY % Float.POSITIVE_INFINITY));
        assertTrue(Float.isNaN(Float.NEGATIVE_INFINITY / Float.NEGATIVE_INFINITY));
        assertTrue(Float.isNaN(Float.NEGATIVE_INFINITY % Float.NEGATIVE_INFINITY));
    }
    
    public void testOverflow() {
        byte b = Byte.MAX_VALUE;
        assertEquals(Byte.MAX_VALUE + 1, (int)b + 1);
        
        b += 1;
        assertEquals(Byte.MIN_VALUE, b);
        
        assertTrue(Double.isInfinite(Double.MAX_VALUE * Double.MAX_VALUE));
    }
    
    public void testXor() {
        int x = 5;
        int y = 7;
        int xPrime = x ^ y;
        assertEquals(2, xPrime);
        assertEquals(x, xPrime ^ y);
    }
    
    public void testParity() {
        assertEquals(0, xorAll(0, 1, 0, 1));
        assertEquals(1, xorAll(0, 1, 1, 1));
    }
    
    private int xorAll(int first, int... rest) {
        int parity = first;
        for (int num : rest)
            parity ^= num;
        return parity;
    }
    
    public void testBitShifting() {
        assertEquals(10, 5 << 1);
        assertEquals(20, 5 << 2);
        assertEquals(40, 5 << 3);
        assertEquals(20, 40 >> 1);
        assertEquals(10, 40 >> 2);
        
        assertEquals(-20, -10 << 1);
        assertEquals(-5, -10 >> 1);
        
        assertEquals(5, 10 >>> 1);
        assertEquals(2147483643, -10 >>> 1);
        // 1111_1111_1111_1111_1111_1111_1111_0110 = -10
        // 0111_1111_1111_1111_1111_1111_1111_1011 = 2147483643
    }
}
