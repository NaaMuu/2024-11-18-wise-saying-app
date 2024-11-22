package com.ll;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    private final Scanner sc;
    private int lastId;
    private final List<WiseSaying> wiseSayings;

    public App() {
        sc = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        makeSampleData();

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제")) {
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);
                actionDelete(id);
            } else if (cmd.startsWith("수정")) {
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                actionModify(id);
            }
        }
        sc.close();
    }

    private void makeSampleData() {
        addWiseSaying("명언1", "작가1");
        addWiseSaying("명언2.", "작가2");
    }

    private WiseSaying addWiseSaying(String content, String author) {
        int id = ++lastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = addWiseSaying(content, author);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    private void actionDelete(int id) {
        boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);

        if (removed) System.out.println(id + "번 명언을 삭제했습니다.");
        else System.out.println(id + "%d번 명언은 존재하지 않습니다.");
    }

    private void actionModify(int id) {
        WiseSaying foundWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                foundWiseSaying = wiseSaying;
                break;
            }
        }

        if (foundWiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + foundWiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.println("작가(기존) : " + foundWiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();

        foundWiseSaying.setContent(content);
        foundWiseSaying.setAuthor(author);

        System.out.println(id + "번 명언이 수정되었습니다.");
    }
}