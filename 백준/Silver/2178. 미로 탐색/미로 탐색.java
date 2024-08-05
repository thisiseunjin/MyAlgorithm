import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int input = str.charAt(j);
                map[i][j] = (input == '1');
            }
        }

        bfs();

        System.out.println(result);

    }

    public static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        isVisited[0][0] = true;
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int depth = cur[2];

//            System.out.println("( "+cx+", "+cy+" )");

            if (cx == N - 1 && cy == M - 1) {
                result = depth;
                return;
            }

            //4방 탐색을 통해 갈수 있는 곳인지 판단 후 갈 수 있으면 간다.
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!inRange(nx, ny)) continue;
                if (!map[nx][ny]) continue;
                if (isVisited[nx][ny]) continue;

                isVisited[nx][ny] = true;
                q.add(new int[]{nx,ny,depth+1});
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N - 1 && y <= M - 1;
    }
}