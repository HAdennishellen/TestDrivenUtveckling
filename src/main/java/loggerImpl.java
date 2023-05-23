public class loggerImpl  implements Logger {
    @Override
    public void log(Integer number){
        System.out.println("Logging number above 999, number is " + number);
    }
}
