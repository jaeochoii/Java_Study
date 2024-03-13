import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("2자리수 정수(10~99)를 입력해주세요: ");

        int number = scanner.nextInt();

        int tenNumber = number / 10;
        int oneNumber = number % 10;

        if(tenNumber == oneNumber) System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
        else System.out.println("No! 10의 자리와 1의 자리가 같지 않습니다.");
    }
}
