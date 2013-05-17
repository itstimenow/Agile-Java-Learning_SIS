package languageTest;

import java.util.*;
import junit.framework.*;


public class RandomTest extends TestCase {
    
    public void testCoinFlips() {
        final long seed = 100L;
        final int total = 10;
        
        Random random1 = new Random(seed);
        List<Boolean> flips1 = new ArrayList<Boolean>();
        for (int i = 0; i < total; i++)
            flips1.add(random1.nextBoolean());
        
        Random random2 = new Random(seed);
        List<Boolean> flips2 = new ArrayList<Boolean>();
        for (int i = 0; i < total; i++)
            flips2.add(random2.nextBoolean());
        
        assertEquals(flips1, flips2);
    }
}
