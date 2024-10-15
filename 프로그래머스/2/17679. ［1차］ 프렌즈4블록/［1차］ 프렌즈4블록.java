import java.util.*;

class Solution {
    char[][] map;
    int result=0;
    ArrayList<int[]> list;
    boolean hasNext = true;
    int M,N;
    int[] dx = {0,0,1,1};
    int[] dy = {0,1,0,1};
    
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        M = m;
        N = n;
        
        //배열 형태로 저장
        for(int i=0;i<m;i++){
            String str = board[i];
            for(int j=0;j<n;j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        while(true){
            //1. 4개가 만나 있는 곳을 찾아서 list에 넣어둔다.
            step1();
            
            if(!hasNext) {
                break;
            }
            //2. list에 있는걸 순서대로 지운다.
            step2();
            
            //3. 내려 보낸다.
            step3();
        }
        
        return result;
    }
    
    void step1(){
        list = new ArrayList<>();
        
        //1 4개가 만나 있는 곳을 찾아서 list에 넣어둔다.
        boolean flag = false;   //갈 수 있는 추가적인 경로가 있는지 판단하는 boolean
        for(int i=0;i<M-1;i++){
            for(int j=0;j<N-1;j++){
                if(map[i][j]=='*') continue;
                if(map[i][j] != map[i][j+1]) continue;
                if(map[i][j] != map[i+1][j]) continue;
                if(map[i][j] != map[i+1][j+1]) continue;
                
                flag = true;
                list.add(new int[]{i,j});
            }
        }
        
        if(!flag) hasNext = false;
    }
    
    void step2(){
        //2. list에 있는 걸 순서대로 지운다.
        
        for(int[] p : list){
            int x = p[0];
            int y = p[1];
            
            for(int i=0;i<4;i++){
                int cx = x+dx[i];
                int cy = y+dy[i];
                
                if(map[cx][cy]=='*') continue;
                
                map[cx][cy] = '*';
                result++;
            }
            
        }
    }
    
    public void step3(){
        //한 칸씩 위로 올리는 작업을 진행할 것임 ㅇㅅㅇ
        
        for(int j=0;j<N;j++){
            int idx = -1;
            for(int i=M-1;i>-1;i--){
                
                //내 자리가 비어 있지 않으면 그냥 간다.
                if(map[i][j]!='*') continue;
                
                //내 자리가 비어 있으면? 위에 것을 당겨 올 것임.
                
                for(int k=i-1; k>-1 ; k--){
                    if(map[k][j] == '*') continue;
                    
                    map[i][j] = map[k][j];
                    map[k][j] = '*';
                    break;
                }
            }
        }
    }
}