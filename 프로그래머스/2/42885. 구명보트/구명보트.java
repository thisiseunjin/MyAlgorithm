import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        
        //조건1 : 한번에 2명밖에 못탐
        //조건2 : 두사람의 합은 limit를 초과할 수 없음
        
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        while(start<=end){
            int left = people[start];
            int right = people[end];
            if(left+right>limit) {
                //뚱뚱해 못탐 금지 삐빅
                end--;
            }else{
            
            //오케이 성공
            start++;
            end--;
            }
            answer++;
            
        }
        
        
        return answer;
    }
}