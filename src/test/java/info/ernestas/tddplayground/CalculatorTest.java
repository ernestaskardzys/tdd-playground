package info.ernestas.tddplayground;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(0, calculator.add("0"));
    }

    @Test
    public void testAdd_whenPassed1Return1() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testAdd_whenPassed2Return2() {
        assertEquals(2, calculator.add("2"));
    }

    @Test
    public void testAdd_whenPassed13Return4() {
        assertEquals(4, calculator.add("1,3"));
    }

    @Test
    public void testAdd_whenPassed50805Return135() {
        assertEquals(135, calculator.add("50,80,5"));
    }

    @Test
    public void testAdd_whenPassedBigNumberOfParameters() {
        assertEquals(21, calculator.add("1,2,3,4,5,6"));
    }

    @Test(expected = RuntimeException.class)
    public void testAdd_whenPassedANegativeNumber_shouldThrowAnException() {
        calculator.add("1,2,-3,4,5,6");
    }

    @Test
    public void testAdd_withACustomSeparator() {
        assertEquals(12, calculator.add("//= 8=3=1"));
    }

}
