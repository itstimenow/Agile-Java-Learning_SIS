package languageTest;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import junit.framework.TestCase;


public class ArrayTest extends TestCase {
    
    // 0   1   2   3
    // 4   5   6   7
    // 8   9  10  11
    public void testTwoDimensionalArrays() {
        int rows = 3;
        int cols = 4;
        int count = 0;
        int[][] matrix = new int[rows][cols];
        for (int x = 0; x < rows; x++)
            for (int y = 0; y < cols; y++)
                matrix[x][y] = count++;
        assertEquals(11, matrix[2][3]);
        assertEquals(6, matrix[1][2]);
    }
    
    // 0
    // 1  2
    // 3  4  5
    public void testPartialDimensions() {
        final int rows = 3;
        int[][] matrix = new int[rows][];
        matrix[0] = new int[] { 0 };
        matrix[1] = new int[] { 1, 2 };
        matrix[2] = new int[] { 3, 4, 5 };
        assertEquals(1, matrix[1][0]);
        assertEquals(5, matrix[2][2]);
        
        int[][] matrix2 = { { 0 }, { 1, 2 }, { 3, 4, 5 } };
        assertEquals(0, matrix[0][0]);
        assertEquals(3, matrix[2][0]);
    }
    
    public void testArrayEquality() {
        int[] a = { 1, 2, 3 };
        int[] b = { 1, 2, 3 };
        
        assertFalse(a == b);
        assertFalse(a.equals(b));
        assertTrue(Arrays.equals(a, b));
    }
    
    public void testArraysAsList() {
        List<String> nameList = new ArrayList<String>();
        nameList.add("Mike");
        nameList.add("David");
        nameList.add("Bob");
        
        List<String> names = Arrays.asList("Mike", "David", "Bob");
        assertEquals(nameList, names);
        
        names = Arrays.asList(new String[] { "Mike", "David", "Bob" });
        assertEquals(nameList, names);
    }
}
