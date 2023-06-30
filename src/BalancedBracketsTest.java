import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

public class BalancedBracketsTest {

    BalancedBrackets bb = new BalancedBrackets();

    @Test
    public void testBalancedBrackets_tooManyOpenBrackets() {
        assertFalse(bb.balancedBrackets("({1)"));
    }

    @Test
    public void testBalancedBrackets_tooManyClosedBrackets() {
        assertFalse(bb.balancedBrackets("({1})>"));
    }

    @Test
    public void testBalancedBrackets_emptyString() {
        assertTrue(bb.balancedBrackets(""));
    }

    @Test
    public void testBalancedBrackets_balancedComboBrackets() {
        assertTrue(bb.balancedBrackets("<({})>"));
    }

    @Test
    public void testBalancedBrackets_mismatchedBrackets() {
        assertFalse(bb.balancedBrackets("<({)}>"));
    }
}