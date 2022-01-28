package info.ernestas.tddplayground;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockingClassTest {

    @Mock
    private OtherClass otherClass;

    @Test
    public void testSomething() {
        MockingClass testClass = new MockingClass();
        assertTrue(testClass.testIfTrue());
    }
    
    @Test
    public void testWithMockito() {
        var mockedResult = "MockedResult";
        when(otherClass.getResult()).thenReturn(mockedResult);
        
        MockingClass testClass = new MockingClass(otherClass);
        assertEquals(mockedResult, testClass.getResultFromOtherClass());
    }
    
}
