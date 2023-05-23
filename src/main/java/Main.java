import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    InputStream inputStream;
    OutputStream outputStream;
    public Main(InputStream inputStream, ByteArrayOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public static void main(String[] args){
        StringCalculatorImpl calculator = new StringCalculatorImpl(new loggerImpl());
        Scanner scanner = new Scanner(System.setIn());
        String input = scanner.next();
        while(!Objects.equals(input, "")){
            int result = calculator.add(input);
            String resultText = "The result is " + result;
            System.setOut(resultText).;
            input = scanner.next();
        }
    }
}
