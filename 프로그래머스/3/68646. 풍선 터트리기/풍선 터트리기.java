import java.util.*;
class Solution {
    
    static int N;
    public int solution(int[] a) {
        int answer = 2;
        N = a.length;
        if(N<3) return N;
        
        
        int[] left = new int[N];
        int[] right = new int[N];
        
        int min  = a[0];
        //내기준 왼쪽 최소값 저장
        for(int i=1;i<N;i++){
            left[i] = min;
            min = Math.min(a[i], min);
        }
        
        //내기준 오른쪽 최소값 저장
        min = a[N-1];
        for(int i=N-1;i>0;i--){
            right[i]=min;
            min = Math.min(min, a[i]);
        }
        
        for(int i=1;i<N-1;i++){
            if(left[i]<a[i] && right[i]<a[i]) continue;
            answer++;
            // System.out.println(answer);
        }

        return answer;
    }
}