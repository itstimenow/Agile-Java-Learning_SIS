package languageTest;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;


public class LoopTest extends TestCase {
    
    public void testPalindrome() {
        assertFalse(isPalindrome("abcdef"));
        assertTrue(isPalindrome("abcba"));
    }
    
    private static boolean isPalindrome(String string) {
        int limit = string.length() / 2;
        for (int forward = 0, backward = string.length() - 1; 
             forward < limit;
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
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        return fib(x - 1) + fib( x - 2);
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
    
    public void testEndTrim() {
        assertEquals("", endTrim(""));
        assertEquals(" x", endTrim(" x "));
        assertEquals("y", endTrim("y"));
        assertEquals("xaxa", endTrim("xaxa"));
        assertEquals("", endTrim(" "));
        assertEquals("xxx", endTrim("xxx \n \t \f \r   "));
    }
    
    private String endTrim(String source) {
        int i = source.length() - 1;
        while (i >= 0) {
            char ch = source.charAt(i);
            if (!Character.isWhitespace(ch))
                break;
            i--;
        }
        return source.substring(0, i + 1);
    }
    
    public void testLabeledBreak() {
        ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(5);
        row1.add(2);
        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.add(3);
        row2.add(4);
        
        table.add(row1);
        table.add(row2);
        assertTrue(found(table, 3));
        assertFalse(found(table, 8));
    }
    
    private boolean found(ArrayList<ArrayList<Integer>> table, int target) {
        boolean found = false;
        
        search:
        for (ArrayList<Integer> row : table) {
            for (Integer value : row)
                if (value == target) {
                    found = true;
                    break search;
                }
        }
        
        return found;
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
