import java.util.*;

class Solution {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int[][] map = new int[101][101];
    static boolean[][] isVisited = new boolean[101][101];
    static int cx, cy;
    static int ix, iy;
    static int result = (int)1e9;
    static int[][] rec = new int[101][101];
    static class Point{
        int x,y;
        // int dir;
        int depth;
        // int cost;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public Point(int x, int y,  int depth){
            this.x=x;
            this.y=y;
            // this.dir = dir;
            this.depth = depth;
            // this.cost = cost;
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        rec = rectangle.clone();
        
        for(int i=0;i<rectangle.length;i++){
            // draw(rectangle[i][0]*2,rectangle[i][1]*2,rectangle[i][2]*2,rectangle[i][3]*2);
            fill(rectangle[i][0]*2,rectangle[i][1]*2,rectangle[i][2]*2,rectangle[i][3]*2);
        }
        
    
        
        iy = itemY*2;
        ix = itemX*2;
        
        bfs(new Point(characterX*2,characterY*2));
        
        // print_boolean();
        
        return result;
    }
    
    public void bfs(Point start){
        Queue<Point> q = new ArrayDeque<>();
        
        isVisited[start.x][start.y] = true;
        q.add(start);
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            if(p.x==ix && p.y==iy){
                result = p.depth/2;
                return;
            }
            
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                if(!inRange(nx,ny)) {
                    // System.out.println("1");
                    continue;
                }
                // if(inRec(nx,ny)) {
                //     continue;
                // }
                if(map[nx][ny]!=1) continue;
                if(isVisited[nx][ny])continue;
                
                isVisited[nx][ny] = true;

                
                q.add(new Point(nx,ny,p.depth+1));
            }
                
            
        }
    }
    
    //격자 안에 사각형 그리기
    public void draw(int x1, int y1, int x2, int y2){
        //[[1,1,5,7]]
        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                map[i][j]+=1;
            }
        }
    }
    public void fill(int x1, int y1, int x2, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(map[i][j]==2) continue;
                map[i][j]=2;
                if(i==x1||i==x2||j==y1||j==y2){
                    map[i][j]=1;
                }
            }
        }
    }
    
    
    public boolean inRec(int x, int y){
        //4변이 모두 둘러쌓여 있으면? 내부에 있는 것이다.
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(!inRange(nx,ny)) return false;
            if(map[nx][ny]==0) return false;
        }
        
        return true;
        
    }
    
  
    
    public boolean inRange(int x, int y){
        if(x>100||y>100||x<0||y<0) return false;
        return true;
    }
    
    public void print(){
        for(int i=10;i>=0;i--){
            for(int j=0;j<11;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    
     public void print_boolean(){
         System.out.println("============================");
        for(int i=10;i>=0;i--){
            for(int j=0;j<11;j++){
               if(isVisited[i][j])
                   System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}