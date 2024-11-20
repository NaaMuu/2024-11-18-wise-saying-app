package com.ll;
import java.util.*;

class Quote {
    int id;
    String name;
    String quote;
}

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] strs = new String[2];
        String[] names = new String[2];
        int count = 0;
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            // --- 등록
            if (cmd.equals("등록") && count < 2) {
                System.out.print("명언 : ");
                strs[count] = sc.nextLine();
                System.out.print("작가 : ");
                names[count] = sc.nextLine();
                System.out.println((count + 1) + "번 명언이 등록되었습니다.");
                count++;
            }

            // --- 목록
            else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                while( count == 0 )
                for (int i = count; i > 0; i--) {
                    System.out.println(i + " / " + names[i - 1] + " / " + strs[i - 1]);
                }
            }

            // --- 삭제
            else if (cmd.equals("삭제")) {
                System.out.print("?id=");
                int id = sc.nextInt();
                sc.nextInt();
                if (id < 1 || id > 2) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
                else if (strs[id - 1] == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
                else {
                    strs[id - 1] = null;
                    names[id - 1] = null;
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                    count--;
                }
            }

            // --- 수정
            else if (cmd.equals("수정")) {
                System.out.print("?id=");
                int id = sc.nextInt();
                sc.nextInt();
                if (id < 1 || id > 2) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
                else if (strs[id - 1] == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
                else {
                    System.out.println("명언(기존) : " + strs[id - 1]);
                    System.out.println("명언 : ");
                    strs[id - 1] = sc.nextLine();
                    System.out.println("작가(기존) : " + names[id - 1]);
                    names[id - 1] = sc.nextLine();
                }
            }

            // --- 종료
            else if (cmd.equals("종료")) {
                break;
            }
        }
        sc.close();
    }
}