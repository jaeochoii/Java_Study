package Week6;

import java.util.Scanner;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String turn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("["+name+"]: <Enter>");
        return scanner.nextLine();
    }

    public boolean RandomNum() {
        int num[] = new int[3];

        for(int i = 0; i < 3; i += 1) {
            System.out.print("\t");
            num[i] = (int)(Math.random()*3+1);
            System.out.print(num[i]+"\t");
        }

        boolean result = true;
        for(int i = 0; i < 3; i += 1) {
            if(num[0] != num[i]) {
                result = false;
                break;
            }
        }

        return result;
    }
}

class GamblingGame {
    Person person[] = new Person[2];
    Scanner scanner = new Scanner(System.in);

    public GamblingGame() {
        for(int i = 0; i < person.length; i += 1) {
            System.out.print((i+1) + "번째 선수 이름>>");
            person[i] = new Person(scanner.next());
        }
    }

    public void Run() {
        while(true) {
            for(int i = 0; i < person.length; i += 1) {
                String s = person[i].turn();
                if(s.equals("")) {
                    if(person[i].RandomNum()) {
                        System.out.println("\t" + person[i].getName() + "님이 이겼습니다!");
                        return;
                    }
                    else {
                        System.out.println("\t" + "아쉽군요!");
                    }
                }
                else {
                    System.out.println("<Enter>키만 입력 가능합니다.");
                    return;
                }

            }
        }
    }
}

public class Problem2 {
    public static void main(String[] args) {
        GamblingGame game = new GamblingGame();
        game.Run();
    }
}
