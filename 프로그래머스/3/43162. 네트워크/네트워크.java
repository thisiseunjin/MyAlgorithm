import java.util.*;
class Solution {
    ArrayList<Integer>[] list;
    int N;
    int result;
    boolean[] isVisited;
    boolean isPossible;
    public int solution(int n, int[][] computers) {
        N = n;
        list = new ArrayList[N];
        isVisited = new boolean[N];
        for(int i=0;i<N;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //연결되지 않음.
                if(computers[i][j]==0) continue;
                
                int v1 = i;
                int v2 = j;
                
                list[i].add(j);
            }
        }
        
        for(int i=0;i<n;i++){
            if(isVisited[i]) continue;
            dfs(i);
            result++;
            
        }
      
        
        
        
        return result;
    }
    
    public boolean dfs(int v){
        boolean flag = false;
        
        //들어와서 방문 체크 진행
        isVisited[v] = true;
        
        //갈수 있는 곳이면? 간다.
        for(int node : list[v]){
            if(isVisited[node]) continue;
            
            dfs(node);
        }
        
        return flag;
    }
}