package com.ll.exam;

//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;


//생성자를 위에 두는 이유는 아래 run, list, write, remove 가 동시에 접근할 요소들을 모아 쉽게 접근하도록 함
public class App {
    private Scanner sc;


    //생성자에 의해서 초기화가 이루어짐짐
   public App() {
        sc = new Scanner(System.in);

    }


    public void run() {
        System.out.println("===== 명언 SSG =====");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while (true) {
            System.out.println("명령)");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);


            switch (rq.getPath()) {
                case "등록":
                    WiseSayingController.write(rq);
                    break;
                case "삭제":
                    WiseSayingController.remove(rq);
                    break;
                case "수정":
                    WiseSayingController.modify(rq);
                    break;
                case "목록":
                    WiseSayingController.list(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
        sc.close();
    }

}

