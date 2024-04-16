package Week6;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">>");
        String S = scanner.nextLine();
        StringBuffer SB = new StringBuffer(S);

        while(true) {
            System.out.print("명령: ");
            String A = scanner.next();

            if(A.equals("그만")) {
                System.out.print("종료합니다.");
                break;
            }

            String tokens[] = A.split("!");

            if(tokens.length != 2) {
                System.out.println("잘못된 명령어입니다!");
            }
            else {
                if(tokens[0].length() == 0) {
                    System.out.println("잘못된 명령입니다!");
                    continue;
                }

                int index = SB.indexOf(tokens[0]);
                if(index == -1) {
                    System.out.println("찾을 수 없습니다!");
                    continue;
                }

                SB.replace(index, index+tokens[0].length(), tokens[1]);
                System.out.println(SB.toString());
            }
        }
    }
}
