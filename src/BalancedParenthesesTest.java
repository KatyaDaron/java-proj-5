import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class BalancedParenthesesTest {

    BalancedParentheses bp = new BalancedParentheses();

    @Test
    public void testBalancedParentheses_balancedParens() {
        assertTrue(bp.balancedParentheses("(1)"));
    }

    @Test
    public void testBalancedParentheses_startWithClosedParens() {
        assertFalse(bp.balancedParentheses(")("));
    }

    @Test
    public void testBalancedParentheses_emptyString() {
        assertTrue(bp.balancedParentheses(""));
    }

    @Test
    public void testBalancedParentheses_tooManyClosedParens() {
        assertFalse(bp.balancedParentheses("(1))"));
    }

    @Test
    public void testBalancedParentheses_tooManyOpenParens() {
        assertFalse(bp.balancedParentheses("((1)"));
    }
}
