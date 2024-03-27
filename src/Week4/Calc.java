package Week4;

import java.util.Scanner;

class Calculator {
    private static int op1, op2;

    public static int Add() {
        return op1 + op2;
    }

    public static int Sub() {
        return op1 - op2;
    }

    public static int Mul() {
        return op1 * op2;
    }

    public static int Div() {
        return op1 / op2;
    }

    public static void setValue(int operand1, int operand2) {
        op1 = operand1;
        op2 = operand2;
    }
}

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("두 정수와 연산자를 입력하시오>> ");

        int operand1 = scanner.nextInt();
        int operand2 = scanner.nextInt();
        String signal = scanner.next();

        System.out.print(calculate(operand1, operand2, signal));
    }

    public static int calculate(int op1, int op2, String sig) {
        Calculator.setValue(op1, op2);

        if(sig.equals("+")) return Calculator.Add();
        else if(sig.equals("-")) return Calculator.Sub();
        else if(sig.equals("*")) return Calculator.Mul();
        else if(sig.equals("/")) return Calculator.Div();
        else {
            System.out.println("잘못된 연산자 입니다.");
            return 0;
        }
    }
}
