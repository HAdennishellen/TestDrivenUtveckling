import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class StringCalculatorImpl implements StringCalculator {
    Logger logger;
    public StringCalculatorImpl(Logger logger){
       this.logger = logger;
    }
    @Override
    public int add(String input) {
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
            String[] inputArray = input.split("[,\n"+delimiter+"]");
            List<Integer> negativeInputs = new ArrayList<>();
            for (String inputString : inputArray) {
                if(!input.isEmpty()){
                    int nInput = Integer.parseInt(inputString);
                    if(nInput < 0){
                        negativeInputs.add(nInput);
                    }else if(nInput <999){
                        logger.log(nInput);
                    } else {
                        sum += nInput;
                    }
                }
            }
            if(!negativeInputs.isEmpty()){
                StringBuilder message = new StringBuilder("Negative inputs not allowed:" + negativeInputs.get(0));
                for(int i = 1; i < negativeInputs.size();i++){
                    message.append(", ").append(negativeInputs.get(i));
                }
                throw new IllegalArgumentException(message.toString());
            }
            return sum;
        }
    }


}
