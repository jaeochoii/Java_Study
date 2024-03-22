package Week3;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");

        String [] unit = {"가위", "바위", "보"};

        while(true) {
            System.out.print("가위 바위 보 !>>");
            String input = scanner.next();
            if(input.equals("그만")) {
                System.out.print("게임을 종료합니다...");
                break;
            }
            String computer = unit[(int)(Math.random() * 3)];
            String result;

            if((input.equals("가위") && computer.equals("보")) || (input.equals("바위") && computer.equals("가위")) || (input.equals("보") && computer.equals("바위"))) {
                result = "이겼습니다.";
            }
            else if((input.equals("가위") && computer.equals("바위")) || (input.equals("바위") && computer.equals("보")) || (input.equals("보") && computer.equals("가위"))){
                result = "졌습니다.";
            }
            else result = "비겼습니다";

            System.out.println("사용자 = " + input + ", " + "컴퓨터 = " + computer + ", " + result);
        }
        scanner.close();
    }
}
