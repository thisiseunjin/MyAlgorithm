import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int W;
    static int H;

    //나이트로 이동 했을 경우 나의 경로
    static int[] nx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] ny = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][][] isVisited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        isVisited = new boolean[H][W][31];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(result==Integer.MAX_VALUE?-1:result);

    }

    public static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        //맨 왼쪽 위 즉(0,0)으로 넣는다.
        isVisited[0][0][0] = true;
        q.add(new Point(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == H - 1 && p.y == W - 1) {
                result = Math.min(result, p.depth);
                return;
            }

            if (p.count < K) {
                for (int i = 0; i < 8; i++) {
                    int nextX = p.x + nx[i];
                    int nextY = p.y + ny[i];

                    if (!inRange(nextX, nextY)) continue;
                    if (isVisited[nextX][nextY][p.count + 1]) continue;
                    if (map[nextX][nextY] == 1) continue;

                    isVisited[nextX][nextY][p.count + 1] = true;
                    q.add(new Point(nextX, nextY, p.depth + 1, p.count + 1));
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (!inRange(nextX, nextY)) continue;
                if (isVisited[nextX][nextY][p.count]) continue;
                if (map[nextX][nextY] == 1) continue;

                isVisited[nextX][nextY][p.count] = true;
                q.add(new Point(nextX, nextY, p.depth + 1, p.count));
            }

        }
    }

    static boolean inRange(int x, int y) {
        return x <= H - 1 && y <= W - 1 && x >= 0 && y >= 0;
    }

    private static class Point {
        int x;
        int y;
        int depth;
        int count;

        public Point(int x, int y, int depth, int count) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.count = count;
        }

    }


}