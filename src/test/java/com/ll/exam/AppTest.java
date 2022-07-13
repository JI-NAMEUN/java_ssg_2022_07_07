package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void 테스트_실험() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }

    @Test
    public void 테스트_스캐너() { //명령어 미리 입력
        String input = """
                등록
                명언1
                작가1
                """.stripIndent(); //앞공간 없애줌
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in); //system.in은 키보드로 입력해야 함, in은 자동으로 문자열이 들어감

        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();

//결과 예측
        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);
    }
}
