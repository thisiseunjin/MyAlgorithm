import java.util.*;
import java.io.*;
class Solution {
    int[][] map = new int[103][103];
    boolean[][] isVisited = new boolean[103][103];
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int result =0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        for(int i=0;i<103;i++){
            for(int j=0;j<103;j++){
                map[i][j]=-1;
            }
        }
        
        draw(rectangle);
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return result;
    }
    
    public void bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> q = new ArrayDeque<>();
        isVisited[characterX][characterY] = true;   //시작점 방문 표시
        q.add(new int[]{characterX, characterY,0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cost = cur[2];
            int cmap = map[cx][cy];
            
            if((cx == itemX) && (cy == itemY)){
                result = cost/2;
                return;
            }
            
            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(!inRange(nx, ny)) continue;
                if(map[nx][ny] !=1 ) continue;
                if(isVisited[nx][ny]) continue;
                
                isVisited[nx][ny] = true;
                q.add(new int[]{nx,ny,cost+1});
            }
            
            
        }
    }
    
    public void draw(int[][] rectangle){
        for(int i=0;i<rectangle.length;i++){
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            //i+1의 값으로 채우기 작업 진행, 테두리만
            for(int x=x1;x<x2+1;x++){
                for(int y=y1 ; y<y2+1;y++){
                    if ((x == x1 || x == x2 || y == y1 || y == y2)&&map[x][y]!=0) {
                        map[x][y] = 1;  // 테두리를 1로 설정
                    } else {
                        map[x][y] = 0;  // 내부를 0으로 설정
                    }
                    
                }
                
            }
        }
    }
    
    
    public boolean inRange(int x, int y){
        if(x<0 || y<0 || x>102 || y>102) return false;
        return true;
    }
    
    
}