import java.util.*;
class Solution {
    int result=0;   //최대로 모을 수 있는 양의 개수
    ArrayList<Integer>[] list;
    boolean[] isVisited;
    public int solution(int[] info, int[][] edges) {
        
        list = new ArrayList[info.length];
        isVisited = new boolean[info.length];
        for(int i=0;i<list.length;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            
            list[from].add(to);
            // list[to].add(from);
        }
        
        dfs(0,0,0,info);
        
        return result;
    }
    
    public void dfs(int now, int sheep, int wolf, int[] info){
        //방문 체크를 일단 해준다
        isVisited[now] = true;
        if(info[now]==0){
            result = Math.max(result, ++sheep);
            
        }else{
            //늑대인데 늑대+1이 나랑 같거나 크다? 게임 끝임
            if(++wolf>=sheep) return;
        }
        
        for(int i=0;i<list.length;i++){
            for(int j=0;j<list[i].size();j++){
                int next = list[i].get(j);
                if(isVisited[i] && !isVisited[next]){
                    isVisited[next] = true;
                    dfs(next, sheep, wolf, info);
                    isVisited[next] = false;
                }
            }
        }
        
    }
}