import java.util.*;
class Solution {
    int[] dp;
    int result=1; 
    int[][] adj;
    boolean[] isVisited;
    
    public int solution(int N, int[][] road, int K) {
        dp = new int[N+1]; //1번 부터 사용할 것이기 때문임.
        adj = new int[N+1][N+1];
        
        for(int i=0;i<=N;i++){
            Arrays.fill(adj[i], (int)1e9);
        }
        Arrays.fill(dp, (int)1e9);
        dp[1] =0;
        
        
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            adj[a][b] = Math.min(c, adj[a][b]);
            adj[b][a] = Math.min(c, adj[b][a]);
        }
        
        dikstra(N);
        calc(K);

        return result;
    }
    
    public void dikstra(int N){
        //N = 마을의 수, K = 최대 가중치

        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int cur = q.poll(); //현재 내가 있는 곳의 값을 꺼내본다.
            
            //갈 수 있는 곳을 찾는다.
            for(int i=1;i<=N;i++){
                if(i==cur) continue;
                if(adj[cur][i]==(int)1e9) {
                    //내가 못 가는 곳이기 때문에 제외한다.
                    continue;
                }
                
                //내가 갈 수 있는곳이다? 그럼 지금까지 걸린 시간을 체크 해 놓는다.
                if(dp[i] <= dp[cur] + adj[cur][i]) continue;
                
                dp[i] = dp[cur]+adj[cur][i];
                q.add(i);
            }
        }
        
        
        
    }
    
    public void calc(int K){
        for(int i =2;i<dp.length;i++){
            if(dp[i]>K) continue;
            result ++;
        }
    }
}