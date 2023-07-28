import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        //System.out.println(Arrays.toString(people));
        
        int start =0;
        int end = people.length-1;
        int sum=0;
        
        while(true){
            //System.out.println(start +" "+end);
            if(start>=end){
                if(start==end) answer++;
                break;
            }
            
            //제일 큰 애를 넣어본다.
            sum+=people[end];
            //System.out.println(sum);
            if(sum>limit) {
                answer++;
                //System.out.println(answer);
                sum=0;  //현재 누적 합은 0이 된다.
                end--;  //끝값 밀기
                continue;
             }
            
            sum+=people[start];  //제일 작은 애를 넣어본다.
            if(sum>limit) {
                answer++;
               // System.out.println(answer);
                sum=0;  //현재 누적 합은 0이 된다.
                end--;  //끝값 밀기
                continue;
             }
            start++;
        }
        return answer;
    }
}