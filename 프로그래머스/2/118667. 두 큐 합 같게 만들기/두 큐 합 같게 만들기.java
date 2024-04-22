import java.util.*;

class Solution {
    static int maxCount=0;
    static long sum1 =0;
    static long sum2 = 0;
    static Queue<Integer> q1 = new ArrayDeque<>();
    static Queue<Integer> q2 = new ArrayDeque<>();
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        //q1에 값 넣기
        for(int i=0;i<queue1.length;i++){
            int n = queue1[i];
            sum1+=n;
            q1.add(n);
        }
        
        //q2에 값 넣기
        for(int i=0;i<queue2.length;i++){
            int n = queue2[i];
            sum2+=n;
            q2.add(n);
        }
        
        maxCount = (q1.size() + q2.size())*2 +1;
        int result = move();
        
        if(result == maxCount) answer = -1;
        else answer = result;
        
        return answer;
    }
    
    public static int move(){
        int cnt=0;
        while(true){
            if(cnt >= maxCount) break;
            if(sum1==sum2) break;
            
            if(sum1>sum2){
                //q1 합의 값이 q2합의 값보다 크다?
                //q1에서 q2로 넘긴다.
                int n = q1.poll();
                sum1-=n;
                q2.add(n);
                sum2+=n;
            }else{
                int n = q2.poll();
                sum2-=n;
                q1.add(n);
                sum1+=n;
            }
            cnt+=1;
        }
        
        return cnt;
    }
}