package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);

        outer:
        while (true) {
            System.out.println("명령");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.println("명언: ");
                    String context = sc.nextLine().trim();
                    System.out.println("작가: ");
                    String author = sc.nextLine().trim();
                    System.out.println("1번 명령이 등록되었습니다.\n");
                    break;
                case "종료":
                    break outer;
            }
            }

        }

    }

