package info.ernestas.tddplayground.euler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem2Test {

    @Test
    public void testProblem2() {
        Problem2 problem2 = new Problem2();

        assertEquals(10, problem2.getResult(10));
        assertEquals(4613732, problem2.getResult(4_000_000));
    }
}
