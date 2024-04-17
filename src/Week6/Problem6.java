package Week6;

import java.util.Scanner;

class HistoGram {
    String inputEng() {
        StringBuffer stringBuffer=new StringBuffer();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String sentence = scanner.nextLine();
            if(sentence.length()==1 && sentence.contains(";")) {
                System.out.println("히스토그램을 그립니다.");
                break;
            }
            stringBuffer.append(sentence);
        }
        return stringBuffer.toString();
    }

    void checkEng(String engSentence){
        int a=65; int b=97;
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

        System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");

        HistoGram histoGram = new HistoGram();
        String input = histoGram.inputEng();
        histoGram.checkEng(input);
    }
}
