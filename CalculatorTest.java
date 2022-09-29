import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest
{

    Calculator calculator = new Calculator();

    @Test
    public void testValidate()
    {
        assertEquals("Testing valid input with two arguments", true, calculator.validate("1+2"));
        assertEquals("Testing valid input with three arguments", true, calculator.validate("1*99/3"));
        assertEquals("Testing invalid input, starts with operator", false, calculator.validate("+2*33"));
        assertEquals("Testing invalid input, ends with operator", false, calculator.validate("2*33+"));
        assertEquals("Testing invalid input, not a sum", false, calculator.validate("hi"));
    }

}