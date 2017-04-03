package info.ernestas.tddplayground.euler;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class Problem5Test {

    @Test
    public void testProblem5() {
        Problem5 problem5 = new Problem5();

        assertEquals(2520, problem5.getResult());
        assertEquals(232_792_560, problem5.getResultUpTo20());
    }
}
