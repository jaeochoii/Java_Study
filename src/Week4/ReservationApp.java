package Week4;

import java.util.*;

public class ReservationApp {
    public static void main(String[] args) {
        ShowReserve sr = new ShowReserve();
        Scanner scanner = new Scanner(System.in);
        int select;

        while (true) {
            System.out.print("예약<1>, 조회<2>, 취소<3>, 끝내기<4>>>");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    sr.seat_reserve();
                    break;
                case 2:
                    sr.seat_check();
                    break;
                case 3:
                    sr.seat_cancle();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다 (1 ~ 4).");
                    continue;
            }

        }
    }
}

class ShowReserve {
    Scanner scanner = new Scanner(System.in);
    String seats[][] = new String[3][10];

    // 생성자
    ShowReserve() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 10; j++)
                this.seats[i][j] = "---";
    }

    // 입력 받은 좌석 보여주는 메소드
    void seat_watch(int seat) {
        switch (seat) {
            case 1:
                System.out.print("S>> ");
                break;
            case 2:
                System.out.print("A>> ");
                break;
            case 3:
                System.out.print("B>> ");
                break;
        }

        for (int i = 0; i < 10; i++)
            System.out.print(this.seats[seat - 1][i] + " ");
        System.out.println();
    }

    // 예약 메소드
    void seat_reserve() {
        int seat;
        String name = null;
        int seat_Number;
        while (true) {
            System.out.print("좌석구분 s<1>, A<2>, B<3>>>");
            seat = scanner.nextInt();

            try {
                seat_watch(seat);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("다시 선택 해주세요 (1 ~ 3).");
                continue;
            }

            System.out.print("이름>> ");
            name = scanner.next();
            System.out.print("번호>> ");
            seat_Number = scanner.nextInt();

            // 좌석 번호를 잘못 입력하였을 때
            if (seat_Number > 10 || seat_Number < 1) {
                System.out.println("잘못 입력하셨습니다 (1 ~ 10).");
                continue;
            }
            // 이미 예약된 좌석 거르기
            if (!this.seats[seat - 1][seat_Number - 1].equals("---")) {
                System.out.println("이미 예약된 좌석입니다.");
                continue;
            }

            // 없는 좌석을 선택하면 예외 처리
            try {
                this.seats[seat - 1][seat_Number - 1] = name;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("다시 선택 해주세요 (1 ~ 10)");
                continue;
            }

            return;
        }
    }

    // 동명이인 구별 메소드
    int dist_name(String name) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.seats[i][j].equals(name)) {
                    count++;
                }
            }
        }
        return count;
    }

    // 조회 메소드
    void seat_check() {
        for (int i = 0; i < 3; i++) {
            if (i == 0)
                System.out.print("S>> ");
            else if (i == 1)
                System.out.print("A>> ");
            else if (i == 2)
                System.out.print("B>> ");
            for (int j = 0; j < 10; j++) {
                System.out.print(this.seats[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    // 취소 메소드
    void seat_cancle() {
        int seat;
        int name_count;
        int seat_num;
        String name = null;

        while (true) {
            System.out.print("좌석구분 s<1>, A<2>, B<3>>>");
            seat = scanner.nextInt();
            seat_watch(seat);

            System.out.print("이름>> ");
            name = scanner.next();
            name_count = dist_name(name);

            if (name_count > 1) { // 동명이인이 있다면 실행
                System.out.println("동명이인이 있습니다.");
                System.out.print("취소 할 좌석 번호 선택>> ");
                seat_num = scanner.nextInt();

                if (!this.seats[seat - 1][seat_num - 1].equals(name)) {
                    System.out.println("잘못 입력하셨습니다.");
                    continue;
                } else {
                    this.seats[seat - 1][seat_num - 1] = "---";
                    return;
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (this.seats[i][j].equals(name)) {
                            this.seats[i][j] = "---";
                            return;
                        }
                    }
                }
                System.out.println("예약된 이름이 없습니다.");
            }
        }
    }
}