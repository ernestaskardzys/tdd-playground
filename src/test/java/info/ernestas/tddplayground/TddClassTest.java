package info.ernestas.tddplayground;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TddClassTest {

    @Test
    public void testTestClassExists() {
        TddClass tddClass = new TddClass();

        assertNotNull(tddClass.testMethod());
    }

    @Test
    public void testWithZero() {
        TddClass tddClass = new TddClass();

        assertEquals(0, tddClass.sum("0"));
    }

    @Test
    public void testWithOne() {
        TddClass tddClass = new TddClass();

        assertEquals(1, tddClass.sum("1"));
    }

    @Test
    public void testWithTwo() {
        TddClass tddClass = new TddClass();

        assertEquals(2, tddClass.sum("2"));
    }

    @Test
    public void testWithTwo2() {
        TddClass tddClass = new TddClass();

        assertEquals(4, tddClass.sum("1,3"));
    }

}
