package com.ll.exam;

/*
 삭제? id =1을 보고 request를 만들어야 겠다고 판단함
 한번에 구현 어려우니까 TDD틀을 이용
 목표 하나 설정 -> 실패(오류)하기 -> 꼼수를 써서 통과시키기
  */

import java.util.HashMap;
import java.util.Map;

public class Rq {
    String url;
    String path;
    Map<String, String> queryParams;
    private String queryStr;


    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];


        queryParams = new HashMap<>();
        if (urlBits.length == 2) {
            String queryStr = urlBits[1];

            String[] paramBits = queryStr.split("&");

            for (String paramBit : paramBits) {
                String[] paramNameAndValue = paramBit.split("=", 2);

                if (paramNameAndValue.length == 1) {
                    continue;
                }

                String paramName = paramNameAndValue[0].trim();
                String paramValue = paramNameAndValue[1].trim();

                queryParams.put(paramName, paramValue);
            }
        }
    }


    public int getIntParam(String paramName, int defaultValue) { //urlBits url 뒷부분 잘라옴

        if (queryParams.containsKey(paramName) == false) {
            return defaultValue;
        }

//bits는 조각냈다는 의미
        String[] bits = queryStr.split("&");
        String paramValue = queryParams.get(paramName);



        if (paramValue.length() == 0) {
            return defaultValue;
            }


        return Integer.parseInt(paramValue);
        //없으면 디폴트 값 리턴
    }

//
        public String getPath() {
            return path;
        }
    }
