import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ParameterizedTest {

    BalancedBrackets bb = new BalancedBrackets();

    @DataProvider(name = "testConditions")
    public Object[][] testConditions() {

        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<({})>";
        String emptyString = "";
        String tooManyOpenBrackets = "{{{}}";
        String tooManyOpenBrackets2 = "()(";
        String tooManyClosedBrackets = "((<>>))";
        String startClosedBrackets = "][";
        String mismatchedBrackets = "<({)}>";

        return new Object[][] {
                { balancedAngleBrackets, true },
                { balancedComboBrackets, true },
                { emptyString, true },
                { tooManyOpenBrackets, false },
                { tooManyOpenBrackets2, false },
                { tooManyClosedBrackets, false },
                { startClosedBrackets, false },
                { mismatchedBrackets, false }
        };
    }

    @Test(dataProvider = "testConditions")
    public void testBalancedBrackets(String input, boolean expectedOutput) {
        assertEquals(expectedOutput, bb.balancedBrackets(input));
    }
}
