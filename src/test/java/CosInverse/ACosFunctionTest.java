package CosInverse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ACosFunctionTest {
    @Test
    public void test0() {
        assertEquals(1.5707963267945, ACosFunction.acos(0), 0.0);
    }

    @Test
    public void testNegative(){
        assertEquals(1.87548898, ACosFunction.acos(-0.3), 0.00001);
    }

    @Test
    public void testPositive(){
        assertEquals(1.47062891, ACosFunction.acos(0.1), 0.00001);
    }

    @Test
    public void testDegreeResult(){
        assertEquals(120, ACosFunction.acos(-0.5)*180/Constants.PI, 0.001);
    }

    @Test
    public void testOutOfRange(){
        assertTrue(ACosFunction.acos(3)==-1);
    }
}
