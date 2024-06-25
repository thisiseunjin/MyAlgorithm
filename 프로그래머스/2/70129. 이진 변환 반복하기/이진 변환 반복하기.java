import java.util.*;
import java.io.*;
class Solution {
    int removedCnt =0; //제거된 0의 개수
    int tmpCnt=0;
    public int[] solution(String s) {
       
        String str = s;
        
        while(true){
            if(str.equals("1")) break;
            
            tmpCnt++;
            str = toBinary(str);
        }
        
        int[] answer = new int[2];
        answer[0] = tmpCnt;
        answer[1] = removedCnt;
        return answer;
    }
    
    public String toBinary(String s){
        
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='0') {
                removedCnt++;
                continue;
            }
            list.add(ch);
        }
        
        return Integer.toBinaryString(list.size());
        
    }
}