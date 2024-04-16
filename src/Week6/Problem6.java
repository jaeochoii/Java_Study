package Week6;

import java.util.Scanner;

class HistoGram {
    String inputEng() {

        StringBuffer stringBuffer=new StringBuffer();
        Scanner sc = new Scanner(System.in);

        while(true) {
            String sentence = sc.nextLine();
            if(sentence.length()==1 && sentence.contains(";")) {
                System.out.println("종료");
                break;

            }stringBuffer.append(sentence);

        }
        return stringBuffer.toString();

    }

    void checkEng(String engSentence){
        int a=65; int b=97; // 아스키코드 A,a 번호
        char start=65;
        String line = "-";

        while(true) {
            System.out.print(start);
            for(int i=0; i<engSentence.length(); i++) {
                char c = engSentence.charAt(i);
                if(c==a || c==b) {
                    System.out.print(line);
                }
            }

            System.out.println();
            a++; b++; start++;
            if(start>90) {
                break;
            }

        }
    }
}

public class Problem6 {

    public static void main(String[] args) {

        System.out.println("영문 텍스트를 입력하세요");
        System.out.println("종료를 원할경우 세미콜론(;)을 입력해 주세요");

        HistoGram histoGram1 = new HistoGram();
        String input = histoGram1.inputEng();
        histoGram1.checkEng(input);
    }
}
