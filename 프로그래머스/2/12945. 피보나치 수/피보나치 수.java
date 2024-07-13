import java.util.*;
class Solution {
    //n은 2이상 100_000이하인 자연수
    static int[] dp = new int[100_001];
    
    public int solution(int n) {
        //dp 배열 초기화
        Arrays.fill(dp, (int)1e9);
        dp[0] =0;
        dp[1] =1;
        
        fibo(n);
        
        // for(int i=0;i<6;i++){
        //     System.out.println(dp[i]);
        // }
        
        return fibo(n);
        
    }
    
    
    public int fibo(int n){
        //값이 들어 있다면?
        if(dp[n]<(int)1e9) return dp[n]; 
        
        //값이 들어 있지 않다면? 계산해야한다.
        int f1 = fibo(n-2)%1234567;
        int f2 = fibo(n-1)%1234567;
        
        dp[n] = (f1+f2)%1234567;
        
        return dp[n];
    }
}