package com.ll.exam;

/*
 삭제? id =1을 보고 request를 만들어야 겠다고 판단함
 한번에 구현 어려우니까 TDD틀을 이용
 목표 하나 설정 -> 실패(오류)하기 -> 꼼수를 써서 통과시키기
  */

public class Rq {
    String url;
    String path;
    String queryStr;


    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        if (urlBits.length == 2) {
            this.queryStr = urlBits[1];
        }
    }


    public int getIntParam(String paramName, int defaultValue) { //urlBits url 뒷부분 잘라옴

        if (queryStr == null) {
            return defaultValue;
        }

//bits는 조각냈다는 의미
        String[] bits = queryStr.split("&");

        for (String urlBit : bits) { //2개 들어가 있음
           String[] paramNameAndValue = urlBit.split("=", 2); //=기준으로 나눔
            String paramName_ = paramNameAndValue[0]; //id 들어감
            String paramValue = paramNameAndValue[1]; //1들어감

            if (paramName.equals(paramName_)) { //두개를 비교
                return Integer.parseInt(paramValue); //맞으면 리턴
            }
        }

        return defaultValue; //없으면 디폴트 값 리턴
    }

//
        public String getPath() {
            return path;
        }
    }
