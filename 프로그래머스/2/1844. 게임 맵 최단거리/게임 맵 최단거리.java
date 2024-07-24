//최단거리이기 때문에 bfs로 풀면 된당!
import java.util.*;
class Solution {
    int result = (int)1e9;
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    boolean[][] isVisited;
    int N,M;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        isVisited = new boolean[N][M];
        
        bfs(maps);
        
        return result==(int)1e9?-1:result;
    }
    
    public void bfs(int[][] maps){
        Queue<int[]> q = new ArrayDeque<>();
        
        //시작점 넣어주기
        isVisited[0][0] = true;
        q.add(new int[]{0,0,1});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int curX = cur[0];
            int curY = cur[1];
            int curDepth = cur[2];
            
            //종료 조건
            if(curX==N-1 && curY==M-1){
                result = curDepth;
                return;
            }
            
            //갈수 있는 곳으로 간다.
            for(int i=0;i<4;i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                //1. 범위 확인
                if(!inRange(nx,ny)) continue;
                
                //2. 갈수 있는 곳인지 확인
                if(maps[nx][ny]==0) continue;
                
                //3. 갔던 곳인지 확인
                if(isVisited[nx][ny]) continue;
                
                isVisited[nx][ny] = true;
                q.add(new int[]{nx,ny,curDepth+1});
            }
        }
    }
    
    public boolean inRange(int x, int y){
        if(x>N-1 || y>M-1 || x<0 || y<0) return false;
        return true;
    }
    
}