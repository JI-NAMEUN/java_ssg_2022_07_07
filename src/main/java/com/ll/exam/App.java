package com.ll.exam;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//생성자를 위에 두는 이유는 아래 run, list, write, remove 가 동시에 접근할 요소들을 모아 쉽게 접근하도록 함
public class App {
    private Scanner sc;
    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;


    //생성자에 의해서 초기화가 이루어짐짐
   public App() {
        sc = new Scanner(System.in);
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }


    //run 명령이 들어왔을 때 rq에게 넘기고 다시 rq의 case에 따라 이동
    //이렇게 적절한 곳으로 넘겨주는 것을 디스패치 라고 함(rq의 역할)
    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            System.out.println("명령)");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);


            switch (rq.getPath()) {
                case "등록":
                   write(rq);
                    break;
                case "삭제":
                    remove(rq);
                    break;
                case "목록":
                    list(rq);
                    break;
                case "종료":
                    break outer;
            }
        }
        sc.close();
    }

    //목록 나옴
    private void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
        }
    }

    //등록하는 일
    private void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++wiseSayingLastId; // 명언 글 번호 증가

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    //삭제하는 일
    private void remove(Rq rq) {
        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업중지
        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = findById(paramId);
        // 찾지 못했다면 중지
        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayings.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    private WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }

        return null;
    }
}

