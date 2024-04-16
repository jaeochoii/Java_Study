package Week6;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = null;

        while(true) {
            System.out.print(">>");
            s = scanner.nextLine();

            if(s.equals("그만")) {
                System.out.print("종료합니다...");
                break;
            }

            String a [] = s.split(" ");
            System.out.println("어절 개수는 " + a.length);
        }
    }
}
