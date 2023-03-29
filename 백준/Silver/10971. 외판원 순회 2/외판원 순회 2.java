import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static long result_min = Integer.MAX_VALUE;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        //dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, i, 0);
        }
        System.out.println(result_min);

    }

    public static void dfs(int start, int now, long cost) {
        if(allVisited()){
            if(map[now][start]!=0){
                result_min = Math.min(result_min,cost+map[now][0]);
            }
            return;
        }

        for (int i = 1; i < N; i++) {
            if(!visited[i]&&map[now][i]!=0){
                visited[i] = true;
                dfs(start,i,cost+map[now][i]);
                visited[i]=false;
            }
        }
    }

    public static boolean allVisited() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}