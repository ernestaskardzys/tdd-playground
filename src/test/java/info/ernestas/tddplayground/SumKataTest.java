package info.ernestas.tddplayground;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumKataTest {

    private SumKata sumKata;

    @Before
    public void setUp() {
        sumKata = new SumKata();
    }

    @Test
    public void testWithZero() {
        assertEquals(0, sumKata.sum("0"));
    }

    @Test
    public void testWithOne() {
        assertEquals(1, sumKata.sum("1"));
    }

    @Test
    public void testWithTwo() {
        assertEquals(2, sumKata.sum("2"));
    }

    @Test
    public void testWithOneThree() {
        assertEquals(4, sumKata.sum("1,3"));
    }

    @Test
    public void testWithFiftyEightyFive() {
        assertEquals(135, sumKata.sum("50,80,5"));
    }

    @Test
    public void testWithMultiple() {
        assertEquals(21, sumKata.sum("1,2,3,4,5,6"));
    }

    @Test(expected = NegativeNumberPassedException.class)
    public void testWithNegativeNumber() {
        sumKata.sum("1,-2,8,6");
    }

    @Test(expected = NegativeNumberPassedException.class)
    public void testWithNegativeNumber2() {
        sumKata.sum("-10");
    }

    @Test
    public void testWithDifferentDelimiters() {
        assertEquals(12, sumKata.sum("//= 8=3=1"));
    }

    @Test
    public void testWithDifferentDelimiters2() {
        assertEquals(15, sumKata.sum("//> 9>5>1"));
    }

    @Test(expected = NegativeNumberPassedException.class)
    public void testWithDifferentDelimiters3() {
        sumKata.sum("//M 1M-8M7");
    }

    @Test
    public void testWithHigherThen1000() {
        assertEquals(12, sumKata.sum("9,1008,3"));
    }

    @Test
    public void testWithHigherThen1000_2() {
        assertEquals(8, sumKata.sum("//] 1]3]4]1000"));
    }

    @Test(expected = NegativeNumberPassedException.class)
    public void testWithHigherThen1000_3() {
        sumKata.sum("//; 7;4;-6");
    }

}
