package Week3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("곱하고자 하는 두 수 입력>>");
            try {
                int input1 = scanner.nextInt();
                int input2 = scanner.nextInt();
                System.out.println(input1 + "x" + input2 + "=" + input1 * input2);
                break;
            } catch (InputMismatchException e) {
                System.out.println("정수가 아닌 값이 입력되었습니다. 다시 입력해주세요.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}

