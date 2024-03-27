package Week4;

import java.util.Scanner;

class Phone {
    String name, phone;
    public Phone(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("인원수>>");
        int peopleCnt = scanner.nextInt();

        Phone[] phone = new Phone[peopleCnt];

        for(int i = 0; i < peopleCnt; i += 1) {
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>>");
            String name = scanner.next();
            String number = scanner.next();
            phone[i] = new Phone(name, number);
        }

        System.out.println("저장되었습니다...");

        while(true) {
            System.out.print("검색할 이름>>");
            String name = scanner.next();

            if(name.equals("그만")) break;

            boolean isFind = false;

            for(int i = 0; i < phone.length; i += 1) {
                if(phone[i].name.equals(name)) {
                    System.out.println(name + "의 번호는 " + phone[i].phone + "입니다.");
                    isFind = true;
                    break;
                }
            }

            if(!isFind) System.out.println(name + "이 없습니다.");
        }

        scanner.close();
    }
}
