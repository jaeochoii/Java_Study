package Week6;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem3 {
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

            StringTokenizer st = new StringTokenizer(s, " ");
            int n = st.countTokens();
            System.out.println("어절 개수는 " + n);
        }
    }
}
