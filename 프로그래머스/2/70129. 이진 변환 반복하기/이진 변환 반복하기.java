import java.util.*;

class Solution {
    int removed0 = 0; //제거된 0의 개수
    int tmpCount = 0; //이진 변환을 수행한 횟수
    
    public int[] solution(String s) {
        
        while(true){
            if(s.equals("1")) break;
            
            tmpCount++;
            s = func(s);
        }
        
        return new int[]{tmpCount, removed0};
    }
    
    public String func(String x){
        String str = "";
        
        //원본 문자열의 길이
        int originLength = x.length();
        
        //0을 제거한다.
        str = x.replace("0","");
        
        //제거된 0의 개수
        removed0+=(originLength - str.length());
        
        //x의 길이를 2진법으로 변환하여 반환한다.
        return Integer.toBinaryString(str.length());
    }
}