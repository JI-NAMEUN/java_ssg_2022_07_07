package com.ll.exam;


import java.util.ArrayList;
import java.util.List;

//데이터를 저장하고 보관하는 담당
public class WiseSayingRepository {
    public int wiseSayingLastId;
    public List<WiseSaying> wiseSayings;

    WiseSayingRepository() {
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }

    public WiseSaying findById(int paramId) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == paramId) {
                return wiseSaying;

            }
        }
        return null;
    }
}