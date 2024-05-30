import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] map;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static StringBuilder sb = new StringBuilder();
    static int T = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            //입력 받기
            dp = new int[N][N];
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();

            sb.append("Problem ").append(++T).append(": ").append(dp[N - 1][N - 1]).append("\n");


        }

        System.out.println(sb);

    }

    public static void dijkstra() {

        //dp 배열 초기화
        init();

        Queue<int[]> q = new ArrayDeque<>();
        dp[0][0] = map[0][0];
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {

            //현재 내가 존재하는 정점의 번호
            int[] p = q.poll();

            int px = p[0];
            int py = p[1];

            //4방 탐색 진행해서 갈 수 있는 곳이 있는지 찾아본다.
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (!inRange(nx, ny)) continue;   //범위를 벗어난 곳이면 못간다.

                // dp[nx][ny]까지 가는 길이 현재 내가 가는 비용보다 작으면 갈 필요가 없음.
                if (dp[nx][ny] <= dp[px][py] + map[nx][ny]) continue;

                q.add(new int[]{nx, ny});
                dp[nx][ny] = dp[px][py] + map[nx][ny];
            }


        }


    }

    public static boolean inRange(int x, int y) {
        if (x < 0 || y < 0 || x > N - 1 || y > N - 1) return false;
        return true;
    }

    public static void init() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = (int) 1e9;
            }
        }
    }


}