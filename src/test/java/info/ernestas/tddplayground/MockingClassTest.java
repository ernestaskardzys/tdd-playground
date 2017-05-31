package info.ernestas.tddplayground;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class MockingClassTest {
    
    @Test
    public void testSomething() {
        MockingClass testClass = new MockingClass();
        assertTrue(testClass.testIfTrue());
    }
    
    @Test
    public void testWithMockito() {
        OtherClass otherClass = Mockito.mock(OtherClass.class);
        when(otherClass.getResult()).thenReturn("MockedResult");
        
        MockingClass testClass = new MockingClass(otherClass);
        assertEquals("MockedResult", testClass.getResultFromOtherClass());
    }
    
}
