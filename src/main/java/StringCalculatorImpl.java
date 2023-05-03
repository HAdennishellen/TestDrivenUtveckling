import java.util.Arrays;

public class StringCalculatorImpl implements StringCalculator {

    @Override
    public int add(String input) {
        //TODO implement
        if(input.isEmpty()){
            return 0;
        }
        else{
            String[] numArray = input.split(",");
            int sum = 0;
            for (String num : numArray) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }

//        String[] delimiters = {",", "\n", ";"};
//        if(input.startsWith("//")){
//            int delimiterIndex = input.indexOf('\n');
//            String delimiter = input.substring(2, )
//        }

    }
}
