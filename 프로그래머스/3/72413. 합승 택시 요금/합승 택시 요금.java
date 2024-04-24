import java.util.*;
class Solution {
    int[][] adj;
    int N;
    int result = 20000000;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        N = n;
        adj = new int[n+1][n+1];
        
        // 초기 설정, INF로 두고 나에게 오는 길은 0으로 설정 진행
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==j){
                    adj[i][j] = 0;
                    continue;
                }
                
                adj[i][j] = 20000000;
            }
        }
        
        for(int i=0;i<fares.length;i++){
           
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int ad = fares[i][2];
            
            adj[v1][v2] = ad;
            adj[v2][v1] = ad;
        }
        
        //플로이드 와살 진행
        for(int k=1;k<n+1;k++){
            for(int i=1; i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
           if(result>adj[s][i] + adj[i][a]+adj[i][b]){
               result = adj[s][i] + adj[i][a]+adj[i][b];
           }
        }
        
        
        
       
        return result;
    }
}