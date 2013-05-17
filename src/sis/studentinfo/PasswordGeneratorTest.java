package sis.studentinfo;

import java.util.*;
import junit.framework.*;


public class PasswordGeneratorTest extends TestCase {
    
    public void testGeneratePassword() {
        PasswordGenerator generator = new PasswordGenerator();
        generator.setRandom(new MockRandom('A'));
        assertEquals("ABCDEFGH", generator.generatePassword());
        
        generator.setRandom(new MockRandom('C'));
        assertEquals("CDEFGHIJ", generator.generatePassword());
    }
 
    
    class MockRandom extends Random {
        
        private int i;
        
        public MockRandom(char startCharValue) {
            i = startCharValue - PasswordGenerator.LOW_END_PASSWORD_CHAR;    
        }
        
        @Override
        protected int next(int bits) {
            i++;
            return i - 1;
        }
    }
}
