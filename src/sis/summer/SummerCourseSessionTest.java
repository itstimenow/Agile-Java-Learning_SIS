package sis.summer;

import java.util.Date;
import junit.framework.TestCase;
import sis.studentinfo.*;

public class SummerCourseSessionTest extends SessionTest {
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session = createSession("ENGL", "200", startDate);
        Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeeksOut, session.getEndDate());
    }
    
    @Override
    protected Session createSession(
            String department, String number, Date startDate) {
        return SummerCourseSession.create(department, number, startDate);
    }
}
