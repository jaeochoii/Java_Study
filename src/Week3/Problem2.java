package Week3;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("금액을 입력하시오>>");
        int cost = scanner.nextInt();

        int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < 8; i += 1) {
            int share = cost / unit[i];
            cost -= unit[i] * share;

            System.out.println(unit[i] +"원 짜리 : " + share + "개");
        }
    }
}
