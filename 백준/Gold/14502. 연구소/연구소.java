import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] originMap;
    static int result = 0;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static Point[] points = new Point[3];   //벽을 세울 곳을 3곳을 골라야한다
    static ArrayList<Point> emptyList = new ArrayList<>();
    static ArrayList<Point> virusList = new ArrayList<>();
    static ArrayList<Point> wallList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
                if (originMap[i][j] == 0) emptyList.add(new Point(i, j));
                else if (originMap[i][j] == 2) virusList.add(new Point(i, j));
                // else wallList.add(new Point(i, j));
            }
        }

        comb(0, 0);

        System.out.println(result);


    }

    //1. 벽을 세울 3곳을 먼저 선정한다.
    static void comb(int cnt, int start) {
        if (cnt == 3) {
            //System.out.println(points.toString());
            //종료가 되면? 해당 구역에 벽을 세우고 바이러스를 퍼트려 본 후 bfs를 통해 안전 구역을 구한다.

            //1. 벽 먼저 세우기
            int map[][] = copy();
            for (Point p : points) {
                map[p.x][p.y] = 1;
            }

            //2. 바이러스 퍼트리기
            map = spreadVirus(map);

            //3. 안전 구역 구하기
            result = Math.max(result, bfs(map));

            return;
        }

        for (int i = start; i < emptyList.size(); i++) {
            //안넣고 보낸다.
            //comb(cnt, i + 1);
            //넣고 보낸다
            points[cnt] = emptyList.get(i);
            comb(cnt + 1, i + 1);
        }
    }

    static int bfs(int map[][]) {
        int count = 0;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        boolean isVisited[][] = new boolean[N][M];

        for (int w = 0; w < emptyList.size(); w++) {
            Point wall = emptyList.get(w);
            int i = wall.x;
            int j = wall.y;


            int tmp = 1;
            if (map[i][j] != 0) continue;
            if (isVisited[i][j]) continue;

            Queue<Point> q = new ArrayDeque<>();
            isVisited[i][j] = true;
            q.add(new Point(i, j));

            while (!q.isEmpty()) {
                Point p = q.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (!inRange(nx, ny)) continue;
                    if (map[nx][ny] != 0) continue;
                    if (isVisited[nx][ny]) continue;

                    isVisited[nx][ny] = true;
                    tmp++;
                    q.add(new Point(nx, ny));
                }
            }
            count += tmp;

        }


        return count;
    }

    static int[][] spreadVirus(int map[][]) {
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        Queue<Point> q = new ArrayDeque<>();
        for (int i = 0; i < virusList.size(); i++) {
            q.add(virusList.get(i));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            //지금 바이러스를 빈곳으로 퍼뜨린다.!!
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (!inRange(nx, ny)) continue;
                if (map[nx][ny] != 0) continue;

                map[nx][ny] = 2;
                q.add(new Point(nx, ny));
            }
        }


        return map;
    }

    static int[][] copy() {
        int map[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = originMap[i][j];
            }
        }

        return map;
    }

    static boolean inRange(int x, int y) {
        if (x > N - 1 || y > M - 1 || x < 0 || y < 0) return false;
        return true;
    }

}