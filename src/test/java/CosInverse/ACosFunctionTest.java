package CosInverse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.InputMismatchException;

/*
 * This class is used to test the functionality of the CosInverse class.
 */
public class ACosFunctionTest {
    ArcCosFunction ac = new ArcCosFunction();
    /*
    Check value at 0.
     */
    @Test
    public void test0() {
        assertEquals(1.5707963267945, ac.acos(0), 0.0001);
    }

    /*
    Checks value at negative 1 boundary.
     */
    @Test
    public void testneg1(){
        assertEquals(3.14159265358979, ac.acos(-1), 0.0001);
    }

    /*
    Checks value at positive 1 boundary.
     */
    @Test
    public void testpos1(){
        assertEquals(0.0, ac.acos(1), 0.0001);
    }

    /*
     Test Negative Values in acos().
     */
    @Test
    public void testNegative(){
        assertEquals(1.87548898, ac.acos(-0.3), 0.00001);
    }

    /*
    Test Positive Values in acos().
     */
    @Test
    public void testPositive(){
        assertEquals(1.47062891, ac.acos(0.1), 0.0001);
    }

    /*
    Check Result of Acos in Degrees.
     */
    @Test
    public void testDegreeResult(){
        assertEquals(120, ac.convert_to_degree(ac.acos(-0.5)), 0.005);
    }

    /*
    Check Result for out of domain input.
     */
    @Test
    public void testOutOfRange(){
        assertTrue(ac.acos(3)==-1);
    }

    /*
    Check result for squareRoot function.
     */
    @Test
    public void testSquareRoot(){
        assertEquals(1.732, ac.squareRoot(3), 0.001);
    }

    /*
    Input Not Defined for Mismatch data type.
     */
    @Test
    public void testWrongInput() {
        assertEquals(-1, ac.acos('s'), 0.0001);
    }
}
