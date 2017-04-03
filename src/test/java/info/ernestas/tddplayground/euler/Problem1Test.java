package info.ernestas.tddplayground.euler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem1Test {

    @Test
    public void testProblem1() {
        Problem1 problem1 = new Problem1();

        assertEquals(23, problem1.getResult(10));
        assertEquals(233168, problem1.getResult(1000));
    }
}
