import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculatorImpl();
    }

    @Test
    public void testEmptyString() {
        Assertions.assertEquals(0, calculator.add(""));
    }
    @Test
    public void testUnknownAmountOfNumbers() {
        Assertions.assertEquals(1, calculator.add("1"));
        Assertions.assertEquals(2, calculator.add("2"));
        Assertions.assertEquals(3, calculator.add("1,2"));
        Assertions.assertEquals(5, calculator.add("1,2,2"));
        Assertions.assertEquals(6, calculator.add("1,2,1,2"));
    }
    @Test
    public void testLineBreaker(){
        Assertions.assertEquals(3, calculator.add("1\n2"));
        Assertions.assertEquals(4, calculator.add("1\n2,1"));
    }
    @Test
    public void testDifferentDelimiterSupport(){
        Assertions.assertEquals(3, calculator.add("//;\n1;2"));
    }
}
