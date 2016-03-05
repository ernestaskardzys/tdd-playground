package info.ernestas.tddplayground;

import org.junit.Assert;
import org.junit.Test;

public class TddClassTest {

    @Test
    public void testTestClassExists() {
        TddClass tddClass = new TddClass();

        Assert.assertNotNull(tddClass.testMethod());
    }

}
