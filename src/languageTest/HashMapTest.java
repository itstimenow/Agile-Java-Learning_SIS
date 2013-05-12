package languageTest;

import java.util.*;
import junit.framework.TestCase;


public class HashMapTest extends TestCase {
    
    private ReportCard card;
    
    @Override
    protected void setUp() {
        card = new ReportCard();
    }
    
    public void testKeys() {
        Set<Student.Grade> expectedGrades = new HashSet<Student.Grade>();
        expectedGrades.add(Student.Grade.A);
        expectedGrades.add(Student.Grade.B);
        expectedGrades.add(Student.Grade.C);
        expectedGrades.add(Student.Grade.D);
        expectedGrades.add(Student.Grade.F);
        
        Set<Student.Grade> grades = new HashSet<Student.Grade>();
        for (Student.Grade grade : card.getMessages().keySet())
            grades.add(grade);
        
        assertEquals(expectedGrades, grades);
    }
    
    public void testValues() {
        Collection<String> expectedMessages = new ArrayList<String>();
        expectedMessages.add(ReportCard.A_MESSAGE);
        expectedMessages.add(ReportCard.B_MESSAGE);
        expectedMessages.add(ReportCard.C_MESSAGE);
        expectedMessages.add(ReportCard.D_MESSAGE);
        expectedMessages.add(ReportCard.F_MESSAGE);
        
        Collection<String> values = card.getMessages().values();
        assertEquals(expectedMessages.size(), values.size());
        for (String message : expectedMessages)
            assertTrue(expectedMessages.contains(message));
    }
    
    public void testEntries() {
        Set<Entry> entries = new HashSet<Entry>();
        
        for (Map.Entry<Student.Grade, String> entry : card.getMessages().entrySet())
            entries.add(new Entry(entry.getKey(), entry.getValue()));
        
        Set<Entry> expectedEntries = new HashSet<Entry>();
        expectedEntries.add(new Entry(Student.Grade.A, ReportCard.A_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.B, ReportCard.B_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.C, ReportCard.C_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.D, ReportCard.D_MESSAGE));
        expectedEntries.add(new Entry(Student.Grade.F, ReportCard.F_MESSAGE));
        
        assertEquals(expectedEntries, entries);
    }
}

class ReportCard {
    
    static final String A_MESSAGE = "Excellent";
    static final String B_MESSAGE = "Very good";
    static final String C_MESSAGE = "Hmmm...";
    static final String D_MESSAGE = "You're not trying";
    static final String F_MESSAGE = "Loser";
    
    private Map<Student.Grade, String> messages = null;
    
    public String getMessage(Student.Grade grade) {
        return getMessages().get(grade);
    }
    
    protected Map<Student.Grade, String> getMessages() {
        if (messages == null)
            loadMessages();
        return messages;
    }
    
    private void loadMessages() {
        messages = new EnumMap<Student.Grade, String>(Student.Grade.class);
        messages.put(Student.Grade.A, A_MESSAGE);
        messages.put(Student.Grade.B, B_MESSAGE);
        messages.put(Student.Grade.C, C_MESSAGE);
        messages.put(Student.Grade.D, D_MESSAGE);
        messages.put(Student.Grade.F, F_MESSAGE);
    }
}

class Student {
    
    enum Grade {
        A, B, C, D, F
    }
}

class Entry {
    
    private Student.Grade grade;
    private String message;
    
    public Entry(Student.Grade grade, String message) {
        this.grade = grade;
        this.message = message;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (this.getClass() != obj.getClass())
            return false;
        
        Entry that = (Entry)obj;
        if (this.grade == that.grade && this.message == that.message)
            return true;
        
        return false;
    }
    
    @Override
    public int hashCode() {
        int multiplier = 41;
        int result = 7;
        result = result * multiplier + grade.hashCode();
        result = result * multiplier + message.hashCode();
        return result;
    }
}
