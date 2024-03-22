package Week3;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 몇개? ");
        int count = scanner.nextInt();
        int[] intArray = new int[count];

        for(int i = 0; i < count; i++) {
            int randomNumber;
            boolean isDuplicate;
            do {
                randomNumber = (int)(Math.random() * 100 + 1);
                isDuplicate = false;
                for (int j = 0; j < i; j++) {
                    if (intArray[j] == randomNumber) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);
            intArray[i] = randomNumber;
        }

        for (int number : intArray) {
            System.out.print(number + " ");
        }
    }
}
