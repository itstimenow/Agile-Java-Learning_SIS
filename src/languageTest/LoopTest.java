package languageTest;

import junit.framework.TestCase;


public class LoopTest extends TestCase {
    
    public void testPalindrome() {
        assertFalse(isPalindrome("abcdef"));
        assertTrue(isPalindrome("abcba"));
    }
    
    private static boolean isPalindrome(String string) {
        for (int forward = 0, backward = string.length() - 1; 
             forward < string.length();
             forward++, backward--) {
            if (string.charAt(forward) != string.charAt(backward))
                return false;
        }
        return true;
    }
    
    public void testForSkip() {
        StringBuilder builder = new StringBuilder();
        String string = "123456";
        for (int i = 0; i < string.length(); i += 2)
            builder.append(string.charAt(i));
        assertEquals("135", builder.toString());
    }
    
    public void testFibonacci() {
        assertEquals(0, fib(0));
        assertEquals(1, fib(1));
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(5, fib(5));
        assertEquals(8, fib(6));
        assertEquals(13, fib(7));
        assertEquals(21, fib(8));
        assertEquals(34, fib(9));
        assertEquals(55, fib(10));
    }
    
    private int fib(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int fib = 0;
        int nextFib = 1;
        int index = 0;
        int temp;
        do {
            temp = fib + nextFib;
            fib = nextFib;
            nextFib = temp;
        } while (++index < x);
        
        return fib;
    }
    
    public void testCommas() {
        String sequence = "1,2,3,4,5";
        assertEquals(sequence, sequenceUsingDo(1, 5));
        assertEquals(sequence, sequenceUsingFor(1, 5));
        assertEquals(sequence, sequenceUsingWhile(1, 5));
        
        sequence = "8";
        assertEquals(sequence, sequenceUsingDo(8, 8));
        assertEquals(sequence, sequenceUsingFor(8, 8));
        assertEquals(sequence, sequenceUsingWhile(8, 8));
    }
    
    private String sequenceUsingDo(int start, int stop) {
        StringBuilder builder = new StringBuilder();
        int i = start;
        do {
            if (i > start)
                builder.append(',');
            builder.append(i);
            i++;
        } while(i <= stop);
        
        return builder.toString();
    }
    
    private String sequenceUsingFor(int start, int stop) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= stop; i++) {
            if (i > start)
                builder.append(',');
            builder.append(i);
        }
        
        return builder.toString();
    }
    
    private String sequenceUsingWhile(int start, int stop) {
        StringBuilder builder = new StringBuilder();
        int i = start;
        while (i <= stop) {
            if (i > start)
                builder.append(',');
            builder.append(i);
            i++;
        }
        
        return builder.toString();
    }
    
    private static int countChars(String input, char ch) {
        int count;
        int i;
        for (i = 0, count = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch)
                count++;
        }
        
        return count;
    }
}
