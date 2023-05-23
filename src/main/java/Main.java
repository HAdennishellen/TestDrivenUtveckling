import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    InputStream inputStream;
    OutputStream outputStream;
    PrintStream printStream;
    public Main(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.printStream = new PrintStream(outputStream);
    }
    public void run(){
        StringCalculatorImpl calculator = new StringCalculatorImpl(new loggerImpl());
        Scanner scanner = new Scanner(inputStream);
        String input;
        while(scanner.hasNext()){
            input = scanner.nextLine();
            int result = calculator.add(input);
            String resultText = "The result is " + result;
            printStream.println(resultText);
        }
    }

    public static void main(String[] args){
      Main main = new Main(System.in, System.out);
      main.run();
    }
}
