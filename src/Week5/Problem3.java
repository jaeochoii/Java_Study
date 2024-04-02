package Week5;

import java.util.Scanner;

abstract class Calc {
    protected int a, b;

    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    abstract int calculate();
}

class Add extends Calc {
    public int calculate() {
        return a+b;
    }
}

class Min extends Calc {
    public int calculate() {
        return a-b;
    }
}

class Mul extends Calc {
    public int calculate() {
        return a*b;
    }
}

class Sub extends Calc {
    public int calculate() {
        return a/b;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("두 정수와 연산자를 입력하세요 >> ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        String op = sc.next();

        Calc cal;
        switch(op) {
            case "+":
                cal = new Add();
                break;
            case "-":
                cal = new Min();
                break;
            case "*":
                cal = new Mul();
                break;
            case "/":
                cal = new Sub();
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
                return;
        }
        cal.setValue(a, b);
        System.out.println(cal.calculate());
    }
}
