import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CalculatorTests {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void whenAdditionArabicDigits() throws IOException {
        String expectedResult = "3";
        String actualResult = new StringParcer().parseString("1 + 2");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void whenDivisionRomeDigits() throws IOException {
        String expectedResult = "II";
        String actualResult = new StringParcer().parseString("VI / III");
        assertEquals(expectedResult, actualResult);
    }
}
