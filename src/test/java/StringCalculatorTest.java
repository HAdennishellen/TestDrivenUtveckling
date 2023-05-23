import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.fail;

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
    @Test
    public void testNegativeInputException(){
        try{
            calculator.add("-1,-2,2");
            fail("Exception expected");

        }catch(IllegalArgumentException ignored){

        }

    }
    @Test
    public void TestCalculatorPrintsToStream(){
        InputStream inputStream = new ByteArrayInputStream("1,2\n".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Main main = new Main(inputStream, outputStream);
        main.main();

        Assertions.assertEquals("3\n", outputStream.toString());
    }

}
