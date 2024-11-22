/*
git add . && git commit -m "" && git push origin main
 */
package com.ll;
import java.util.Scanner;

class WiseSaying extends Object {
    int id;
    String content;
    String author;

    WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
    }
}

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {
    private Scanner sc = new Scanner(System.in);
    private int lastId = 0;
    private WiseSaying[] wiseSayings = new WiseSaying[100];
    private int wiseSayingsSize = 0;

    public void run() {
        System.out.println("== 명언 앱 ==");

        addWiseSaying("명언 1입니다.", "작가 1입니다.");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd(1);
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }

        sc.close();
    }

    private void addWiseSaying (String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings[wiseSayingsSize] = wiseSaying;
        wiseSayingsSize++;
    }

    private void actionAdd(int id) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        addWiseSaying (content, author);

        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying == null) break;
            System.out.println(wiseSaying.id + " / " + wiseSaying.author + " / " + wiseSaying.content);
        }
    }
}