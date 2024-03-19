import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    static int K;
    static int result;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Point> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;  //장애물이 있다? 1이 된다.
            list.add(new Point(x, y, 1));
        }

        for (Point p : list) {
            if (isVisited[p.x][p.y]) continue;
            int cnt = bfs(p);
            result = Math.max(cnt, result);
        }

        System.out.println(result);


    }

    public static void dfs(Point p) {
        int curX = p.x;
        int curY = p.y;

        isVisited[curX][curY] = true;

        result = Math.max(result, p.depth);

        for (int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if (!inRange(nextX, nextY)) continue;
            if (isVisited[nextX][nextY]) continue;
            if (map[nextX][nextY] == 0) continue;

//            isVisited[nextX][nextY] = true;
            dfs(new Point(nextX, nextY, p.depth + 1));
        }

    }

    public static int bfs(Point point) {
        //방문 체크

        int count = 0;
        isVisited[point.x][point.y] = true;
        Queue<Point> q = new ArrayDeque<>();
        q.add(point);

        while (!q.isEmpty()) {
            Point p = q.poll();
            count++;
            result = Math.max(result, p.depth);

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isVisited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                //갈수 있으면 간다
                isVisited[nx][ny] = true;
                q.add(new Point(nx, ny, p.depth + 1));
            }
        }

        return count;
    }

    public static boolean inRange(int x, int y) {
        if (x > N - 1 || y > M - 1 || x < 0 || y < 0) return false;
        return true;
    }

    static private class Point {
        int x, y, depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

}