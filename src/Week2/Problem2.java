package Week2;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        boolean xPossible = false;
        boolean yPossible = false;

        System.out.print("점 (x, y)의 좌표를 입력하시오: ");
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        if(x >= 100 && x <= 200) xPossible = true;

        int y = scanner.nextInt();
        if(y >= 100 && y <= 200) yPossible = true;

        if(xPossible && yPossible) System.out.println("(" + x + ", " + y + ")는 사각형 안에 있습니다.");
        else System.out.println("(" + x + ", " + y + ")는 사각형 안에 없습니다.");
    }
}
