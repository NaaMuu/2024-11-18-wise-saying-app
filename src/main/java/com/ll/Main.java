package com.ll;
import java.util.*;

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

            if (cmd.equals("등록")  && count < 2) {
                System.out.print("명언 : ");
                strs[count] = sc.nextLine();
                System.out.print("작가 : ");
                names[count] = sc.nextLine();
                System.out.println((count +1) + "번 명언이 등록되었습니다.");
                count++;
            }

            else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                while (count > 0) {
                    System.out.println(count + " / " + names[count -1] + " / " + strs[count -1]);
                    count--;
                }
            }

            else if (cmd.equals("삭제")) {
                System.out.print("?id=");
                int id = sc.nextInt();
                sc.nextLine();
                if (strs[id] == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
                else if (strs[id] != null) {
                    strs[id] = "";
                    names[id] = "";
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                }
            }

            else if (cmd.equals("종료")) {
                break;
            }
        }
        sc.close();
    }
}