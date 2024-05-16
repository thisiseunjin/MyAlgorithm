import java.util.*;
class Solution {
    //구명 보트를 가장 적게 사용하는게 목적이다.
    int N;
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int idx =0;
        
        for(int i = people.length-1;i>=idx;i--){
            if(people[i]+people[idx]<=limit){
                idx ++;
                answer++;
            }else{
                answer++;
            }
        }
        
        
        return answer;
    }
}