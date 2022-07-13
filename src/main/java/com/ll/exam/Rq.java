package com.ll.exam;

/*
 삭제? id =1을 보고 request를 만들어야 겠다고 판단함
 한번에 구현 어려우니까 TDD틀을 이용
 목표 하나 설정 -> 실패(오류)하기 -> 꼼수를 써서 통과시키기
  */

public class Rq {
    String url;

    public Rq(String url) {
        this.url = url;
    }

    public int getIntParam(String paramName, int defaultValue) { //urlBits url 뒷부분 잘라옴
        String[] urlBits = url.split("\\?", 2);
        //limit:2 = split 최대 2개까지 나눠짐
        //수정? id=1&no=3 을 "\\?"이용해서 수정(줄바뀜) id=1&no=3로 바꿈
         urlBits = urlBits[1].split("&");
        //urlBits[0]에는 수정, [1]에는 id=1&no=3 이 들어감
        //url안에서 &기준으로 나눔 -> id=1 과 no=3으로 나뉨

        for (String urlBit : urlBits) { //2개 들어가 있음음
           String[] paramNameAndValue = urlBit.split("=", 2); //=기준으로 나눔
            String paramName_ = paramNameAndValue[0]; //id 들어감
            String paramValue = paramNameAndValue[1]; //1들어감

            if (paramName.equals(paramName_)) { //두개를 비교
                return Integer.parseInt(paramValue); //맞으면 리턴
            }
        }

        return defaultValue; //없으면 디폴트 값 리턴
    }
}