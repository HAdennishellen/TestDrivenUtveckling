import java.util.Arrays;

public class StringCalculatorImpl implements StringCalculator {

    @Override
    public int add(String input) {
        //TODO implement
        int sum = 0;
        if(input.isEmpty()){
            return 0;
        }
        else{
            String delimiter = ",";
            if(input.startsWith("//")){
                int delimiterIndex = input.indexOf("\n");
                delimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex+1);
            }
            String[] numArray = input.split("[,\n"+delimiter+"]");
            for (String num : numArray) {
                if(!num.isEmpty()){
                    sum += Integer.parseInt(num);
                }
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
