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

/*
package challenge.Histogram;

import java.util.Scanner;

public class HistoGram {

	String inputEng() {

		StringBuffer stringBuffer=new StringBuffer();
		Scanner sc = new Scanner(System.in);

        // while문 안에 넣어서 종료조건=;로 지정한 후 만족할 때 까지 무한입력 가능하게 하기
		while(true) {
			String sentence = sc.nextLine();
			if(sentence.length()==1 && sentence.contains(";")) {
				System.out.println("종료");
				break;

			}stringBuffer.append(sentence);     // 버퍼에 문자열 저장

		}
		// System.out.println(stringBuffer.toString());  문자열 들어온지 확인해봤음 오 잘들어옴
		return stringBuffer.toString();  // 리턴값을 가져나와 다른메서드에 활용

	}

	void checkEng(String engsentence){
		int a=65; int b=97; // 아스키코드 A,a 번호
		char start=65;
		String line = "-";
		boolean bl=true;

		while(bl) {
			System.out.print(start);
			for(int i=0; i<engsentence.length(); i++) {
				char c = engsentence.charAt(i);
				if(c==a || c==b) {
					System.out.print(line);
				}
			}

			System.out.println();
			a++; b++; start++;
			if(start>90) {       // Z가 넘어가도 계속 출력되는거 막기
				break;
			}

		}

	}

}
* */