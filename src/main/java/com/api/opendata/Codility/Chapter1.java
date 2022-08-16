package com.api.opendata.Codility;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Chapter1 {
    public int solution(int N) {
        // write your code in Java SE 8
        String str = Integer.toBinaryString(N);
        int strLength = str.length();
        int cnt = 0;
        int result = 0;

        Loop1: for(int i=1; i<strLength; i++){
            if(str.charAt(i) == '0'){
                cnt ++;
            }else{
                if((strLength / 2) <= cnt){
                    result = cnt;
                    break Loop1;
                }else{
                    result = (result > cnt) ? result :cnt;
                    cnt = 0;
                }
            }
        }

        return result;
    }
}