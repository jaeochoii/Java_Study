package Week4;

import java.util.Scanner;

class Dictionary {
    private static String [] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String [] eng = {"love", "baby", "money", "future", "hope"};
    public static String kor2Eng(String word) {
        for(int i = 0; i < kor.length; i += 1) {
            if(kor[i].equals(word)) return eng[i];
        }
        return null;
    }
}

public class DicApp {
    public static void main(String[] args) {
        System.out.println("한영 단어 검색 프로그램입니다.");
        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.print("한글 단어? ");
            String inputWord = scanner.next();

            if(scanner.equals("그만")) break;

            if(Dictionary.kor2Eng(inputWord) == null) {
                System.out.println(inputWord + "는 저의 사전에 없습니다.");
                continue;
            }

            String translateWord = Dictionary.kor2Eng(inputWord);
            System.out.println(inputWord + "은 " + translateWord);
        }

        scanner.close();
    }
}
