import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int L, R;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] isSelected;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        isSelected = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isSelected[i][j]) continue;
                    cnt += bfs(new Point(i, j));
                }
            }

            if(cnt==0) break;
            result++;
            init();
        }

        System.out.println(result);


    }


    public static int bfs(Point p) {
        //인구 이동 하는 작업
        ArrayList<Point> list = new ArrayList<>();
        Queue<Point> q = new ArrayDeque<>();
        isSelected[p.x][p.y] = true;
        q.add(p);
        list.add(p);
        int countryCount = 1;
        int totalPopulation = map[p.x][p.y];

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!inRange(nx, ny)) continue;
                if (isSelected[nx][ny]) continue;
                if (!isPossible(map[cur.x][cur.y], map[nx][ny])) continue;

                //갈수 있다? 간다
                list.add(new Point(nx, ny));
                q.add(new Point(nx, ny));
                isSelected[nx][ny] = true;
                totalPopulation += map[nx][ny];
                countryCount++;
            }


        }

        if(countryCount==1) return 0;

        int population = totalPopulation / countryCount;
        for (Point point : list) {
            map[point.x][point.y] = population;
        }

        return list.size();
    }

    static private boolean isPossible(int n1, int n2) {
        return Math.abs(n1 - n2) >= L && Math.abs(n1 - n2) <= R;
    }

    static private boolean inRange(int x, int y) {
        if (x > N - 1 || y > N - 1 || x < 0 || y < 0) return false;
        return true;
    }

    static private void init() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(isSelected[i], false);
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}