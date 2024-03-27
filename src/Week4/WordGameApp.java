package Week4;

import java.util.Scanner;

class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }
}

public class WordGameApp {
    public static void main(String[] args) {
        WordGameApp game = new WordGameApp();
        game.run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("끝말잇기 게임을 시작합니다...");

        System.out.print("게임에 참가하는 인원은 몇명입니까>> ");
        int playerCnt = scanner.nextInt();

        Player[] player = new Player[playerCnt];

        for(int i = 0; i < player.length; i += 1) {
            System.out.print("참가자의 이름을 입력하세요>> ");
            String name = scanner.next();
            player[i] = new Player(name);
        }

        System.out.println("시작하는 단어는 아버지입니다.");

        int i = 0;
        char lastChar = '지';

        while(true) {
            System.out.print(player[i%playerCnt].name + ">> ");
            String word = scanner.next();

            if(word.charAt(0) == lastChar) {
                i += 1;
                lastChar = word.charAt(word.length() - 1);
            }

            else {
                System.out.print(player[i%playerCnt].name + "가 졌습니다.");
                break;
            }
        }

        scanner.close();
    }
}
