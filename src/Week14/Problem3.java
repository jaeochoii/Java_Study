package Week14;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Word {
    private String eng;
    private String kor;

    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }

    public String getEng() {
        return eng;
    }

    public String getKor() {
        return kor;
    }
}

public class Problem3 {
    Scanner scan = new Scanner(System.in);
    Vector<Word> dictionary = new Vector<>();
    Random rand = new Random();
    final int MAX_CHOICE = 4;
    int[] question = new int[MAX_CHOICE];

    public Problem3() {
        setVector();
        System.out.println("**** 영어 단어 테스트 프로그램 '명품영어' 입니다. ****");
        while (true) {
            System.out.println("단어 테스트: 1, 단어 삽입: 2, 종료: 3 >>");
            int choice = scan.nextInt();
            scan.nextLine();  // 버퍼 비우기
            if (choice == 1) {
                game();
            } else if (choice == 2) {
                addWord();
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    public void game() {
        System.out.println("현재 " + dictionary.size() + "개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
        while (true) {
            setChoice();
            int answerNum = rand.nextInt(MAX_CHOICE);
            int answerIndex = question[answerNum];

            System.out.println(dictionary.get(answerIndex).getEng() + "?");

            for (int i = 0; i < question.length; i++) {
                System.out.print("(" + (i + 1) + ")");
                System.out.print(dictionary.get(question[i]).getKor() + " ");
            }
            System.out.print(">> ");

            int choice = scan.nextInt();
            if (choice == -1) {
                System.out.println("종료합니다.");
                break;
            } else if (choice - 1 == answerNum) {
                System.out.println("Excellent !!");
                System.out.println("");
            } else {
                System.out.println("No. !!");
                System.out.println("");
            }
        }
    }

    public void addWord() {
        System.out.println("영어 단어에 '그만'을 입력하면 입력을 종료합니다.");
        while (true) {
            System.out.print("영어 한글 입력 >> ");
            String input = scan.nextLine();
            if (input.equals("그만")) {
                break;
            }
            String[] wordPair = input.split(" ");
            if (wordPair.length == 2) {
                dictionary.add(new Word(wordPair[0], wordPair[1]));
            } else {
                System.out.println("올바른 형식으로 입력해주세요.");
            }
        }
    }

    public void setChoice() {
        for (int i = 0; i < MAX_CHOICE; i++) {
            question[i] = rand.nextInt(dictionary.size());
            for (int j = 0; j < i; j++) {
                if (question[i] == question[j]) {
                    i--;
                    break;
                }
            }
        }
    }

    public void setVector() {
        dictionary.add(new Word("love", "사랑"));
        dictionary.add(new Word("animal", "동물"));
        dictionary.add(new Word("emotion", "감정"));
        dictionary.add(new Word("human", "인간"));
        dictionary.add(new Word("stock", "주식"));
        dictionary.add(new Word("trade", "거래"));
        dictionary.add(new Word("society", "사회"));
        dictionary.add(new Word("baby", "아기"));
        dictionary.add(new Word("honey", "애인"));
        dictionary.add(new Word("doll", "인형"));
        dictionary.add(new Word("bear", "곰"));
        dictionary.add(new Word("picture", "사진"));
        dictionary.add(new Word("painting", "그림"));
        dictionary.add(new Word("fault", "오류"));
        dictionary.add(new Word("example", "보기"));
        dictionary.add(new Word("eye", "눈"));
        dictionary.add(new Word("statue", "조각상"));
    }

    public static void main(String[] args) {
        new Problem3();
    }
}
