package sis.studentinfo;

import java.math.BigDecimal;
import junit.framework.*;


public class AccountTest extends TestCase {
    
    private Account account;
    
    @Override
    protected void setUp() {
        account = new Account();
    }
    
    public void testTransactions() {
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        assertEquals(new BigDecimal("11.10"), account.getBalance());
    }
    
    public void testTransactionAverage() {
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        account.credit(new BigDecimal("2.99"));
        assertEquals(new BigDecimal("4.70"), account.transactionAverage());
    }
}
