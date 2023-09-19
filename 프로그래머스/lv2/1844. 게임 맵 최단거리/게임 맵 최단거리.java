import java.util.*;

class Solution {
    class Point{
        int x;
        int y;
        int depth;
        
        public Point(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    static int SIZE_X;
    static int SIZE_Y;
    
    //4방향 탐색
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    
    public int solution(int[][] maps) {
        SIZE_X=maps.length;
        SIZE_Y= maps[0].length;
        
        int result = -1;
        boolean isFind=false;
        
        //방문체크 배열 등장~!
        boolean isVisited[][] =new boolean[SIZE_X][SIZE_Y];
        
        Queue<Point> q = new LinkedList<>();
        isVisited[0][0] = true; //첫 번째 지점 방문 체크
        q.add(new Point(0,0,1));    //que안에 넣는다.
        
        while(!q.isEmpty()){
            
            //q에서 뽑는다.
            Point now = q.poll();
            
            //현재 있는 곳이 정답지인지 확인한다.
            if(now.x == SIZE_X-1 && now.y ==SIZE_Y-1){
                // result = Math.min(result, now.depth);
                result = now.depth;
                break;
            }
            
            //지금 q에서 갈 수 있는 곳을 탐색한다.
            for(int i=0;i<4;i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                
                //만약 범위를 벗어난다면?
                if(!inRange(nextX, nextY)) continue;
                
                //범위를 만족시키면? 가본적이 있는가? 판단
                if(isVisited[nextX][nextY]) continue;
                
                //갈수 있는곳인가? 판단
                if(maps[nextX][nextY]==0) continue;
                
                //갈수 있는 곳이고 아직 방문 안했다면?
                isVisited[nextX][nextY] = true;
                q.add(new Point(nextX, nextY, now.depth+1));
            }
            
            
        }
        
        
        return result;
    }
    
    public boolean inRange(int x, int y){
        if(x>SIZE_X-1 || y>SIZE_Y-1 || x<0 || y<0) return false;
        return true;
        
    }
}