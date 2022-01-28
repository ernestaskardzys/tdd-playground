package info.ernestas.tddplayground.euler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Problem3Test {

    @Test
    public void testProblem3() {
        Problem3 problem3 = new Problem3();

        assertEquals(29, problem3.getResult(13195));
        assertEquals(5, problem3.getResult(5000));
        assertEquals(6857, problem3.getResult(600851475143L));
    }
}
