import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int M,N,K;
    static int[][] map;
    static boolean[][] isVisited;
    static int sum;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //M,N,K등장~!
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            //왼쪽 아래 꼭짓점
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            //오른쪽 윗 꼭짓점
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            draw(x1,y1,x2,y2);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum =0;
                if(map[i][j]==0 && !isVisited[i][j]) {
                    dfs(i,j);
                    list.add(sum);
                }

            }
        }


        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

    }

    //사각형을 그릴 함수
    public static void draw(int x1, int y1, int x2, int y2){
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j <y2 ; j++) {
                map[i][j]++;
            }
        }
    }

    public static void dfs(int x, int y){
        //현재 방문한곳 방문 체크
        isVisited[x][y] = true;
        sum++;

        //깊이 우선 탐색 시작
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        
        //4방 탐색 시작
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            //1. 범위 내에 들어오는가?
            if(!inRange(nx,ny)) continue;

            //2. 방문한 적이 있는가?
            if(isVisited[nx][ny]) continue;

            if(map[nx][ny]>0) continue;

            dfs(nx,ny);
        }
    }

    static boolean inRange(int x, int y){
        if(x>N-1 || y>M-1 || x<0 || y<0) return false;
        return true;
    }
}