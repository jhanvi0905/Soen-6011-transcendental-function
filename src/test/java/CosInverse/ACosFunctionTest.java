package CosInverse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*
 * This class is used to test the functionality of the CosInverse class.
 */
public class ACosFunctionTest {
    /*
    Check value at 0.
     */
    @Test
    public void test0() {
        assertEquals(1.5707963267945, ACosFunction.acos(0), 0.0);
    }

    /*
     Test Negative Values in acos().
     */
    @Test
    public void testNegative(){
        assertEquals(1.87548898, ACosFunction.acos(-0.3), 0.00001);
    }

    /*
    Test Positive Values in acos().
     */
    @Test
    public void testPositive(){
        assertEquals(1.47062891, ACosFunction.acos(0.1), 0.00001);
    }

    /*
    Check Result of Acos in Degrees.
     */
    @Test
    public void testDegreeResult(){
        assertEquals(120, ACosFunction.acos(-0.5)*180/Constants.PI, 0.001);
    }

    /*
    Check Result for out of domain input.
     */
    @Test
    public void testOutOfRange(){
        assertTrue(ACosFunction.acos(3)==-1);
    }
}
