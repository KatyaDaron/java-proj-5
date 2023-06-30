import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

public class MissingNumberTest {
    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
    private MissingNumber mn = new MissingNumber();

    @Test
    public void testMissingNumber_MissingMax() {
        assertEquals(10, mn.missingNumber(missingMax, 10));
    }

    @Test
    public void testMissingNumber_NoneMissing() {
        assertEquals(0, mn.missingNumber(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingSeven() {
        assertEquals(7, mn.missingNumber(missingSeven, 10));
    }

    @Test
    public void testMissingNumberSort_MissingMax() {
        assertEquals(10, mn.missingNumber(missingMax, 10));
    }

    @Test
    public void testMissingNumberSort_NoneMissing() {
        assertEquals(0, mn.missingNumber(missingNone, 10));
    }

    @Test
    public void testMissingNumberSort_MissingSeven() {
        assertEquals(7, mn.missingNumber(missingSeven, 10));
    }

    @Test
    public void testMissingNumberSum_MissingMax() {
        assertEquals(10, mn.missingNumber(missingMax, 10));
    }

    @Test
    public void testMissingNumberSum_NoneMissing() {
        assertEquals(0, mn.missingNumber(missingNone, 10));
    }

    @Test
    public void testMissingNumberSum_MissingSeven() {
        assertEquals(7, mn.missingNumber(missingSeven, 10));
    }
}