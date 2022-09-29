
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest
{

    Calculator calculator = new Calculator();

    @Test
    public void testAdd()
    {
        assertEquals("Testing add input with two positive integers", 3, calculator.add(1, 2));
        assertEquals("Testing add input with two negative integers", -8, calculator.add(-1, -7));
        assertEquals("Testing add with one positive one negative integer,", 5, calculator.add(-2, 7));
    }


    @Test
    public void testSubtract()
    {
        assertEquals("Testing add input with two two positive integers", 6, calculator.subtract(9, 3));
        assertEquals("Testing add input with two negative integers", 10, calculator.subtract(-5, -5));
        assertEquals("Testing add with one positive one negative integer,", 8, calculator.subtract(-2, 10));
    }

    @Test
    public void testMultiply()
    {
        assertEquals("Testing add input with two two positive integers", 12, calculator.multiply(4, 3));
        assertEquals("Testing add input with two negative integers", 200 , calculator.multiply(-20, -10));
        assertEquals("Testing add with one positive one negative integer,", -16, calculator.multiply(-2, 8));
    }

    @Test
    public void testDivide()
    {
        assertEquals("Testing add input with two two positive integers", 15, calculator.divide(30, 2));
        assertEquals("Testing add input with two negative integers", 4, calculator.divide(-44, -11));
        assertEquals("Testing add with one positive one negative integer,", -7, calculator.divide(-21, 3));
        assertEquals("Testing divide by 0 - should be 0", 0, calculator.divide(5, 0));
        assertEquals("Testing divide where result is not an integer - should be returned as floor", 2, calculator.divide(5, 2));


    }




}

