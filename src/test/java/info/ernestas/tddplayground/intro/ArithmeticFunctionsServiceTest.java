package info.ernestas.tddplayground.intro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticFunctionsServiceTest {

    private ArithmeticFunctionsService service;

    @BeforeEach
    public void setup() {
        service = new ArithmeticFunctionsService();
    }

    @Test
    public void testAdd() {
        double result = service.add(10, 5);
        assertEquals(15, result, 0.01);

        double result2 = service.add(10.5, 1.2);
        assertEquals(11.7, result2, 0.01);
    }

    @Test
    public void testSubtract() {
        double result = service.subtract(10, 5);
        assertEquals(5, result, 0.01);

        double result2 = service.subtract(-10, -5);
        assertEquals(-5, result2, 0.01);
    }

    @Test
    public void testDivide() {
        assertThrows(RuntimeException.class, () -> service.divide(-10, 0));
    }

}
