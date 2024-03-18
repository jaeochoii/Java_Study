package Week3;

public class Calc {
    public static void main(String[] args) {
        double sum = 0.0;

        for(int i = 0; i < args.length; i += 1) {
            sum += Double.parseDouble(args[i]);
        }

        System.out.println("합계: " + sum);
    }
}
