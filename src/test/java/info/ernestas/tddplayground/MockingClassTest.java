package info.ernestas.tddplayground;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author Ernestas.Kardzys
 */
public class MockingClassTest {
    
    @Test
    public void testSomething() {
        MockingClass testClass = new MockingClass();
        Assert.assertTrue(testClass.testIfTrue());
    }
    
    @Test
    public void testWithMockito() {
        OtherClass otherClass = Mockito.mock(OtherClass.class);
        Mockito.when(otherClass.getResult()).thenReturn("MockedResult");
        
        MockingClass testClass = new MockingClass(otherClass);
        Assert.assertEquals("MockedResult", testClass.getResultFromOtherClass());
    }
    
}
