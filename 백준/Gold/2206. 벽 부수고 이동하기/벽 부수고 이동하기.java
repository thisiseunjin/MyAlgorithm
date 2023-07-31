import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int result = (int) 1e9;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
        int x, y;
        int drillCount;   //벽을 부술수 있는가 판단 여부

        public Point(int x, int y, int drillCount) {
            this.x = x;
            this.y = y;
            this.drillCount = drillCount;
//            this.count = count;?
        }
    }

    static int[][][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 2; k++) {
                    dist[i][j][k] = (int) 1e9;
                }
            }
        }


        bfs();

        System.out.println(result==(int)1e9?-1:result);

    }

    public static void bfs() {

        Queue<Point> q = new ArrayDeque<>();

        dist[0][0][0] = 1;
        dist[0][0][1] = 1;

        q.add(new Point(0, 0, 0));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if(dist[p.x][p.y][p.drillCount]>=(int)1e9) continue;


            if (p.x == N - 1 && p.y == M - 1) {
                //종료 조건;
//                dist[N - 1][M - 1] = p.;
                result = Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (!inRange(nx, ny)) continue; //범위를 벗어난다.

                if (map[nx][ny] == 1 && p.drillCount == 0) {
                    //벽인데 한번도 벽 부수고 이동한 적이 없는 경우
                    if (dist[nx][ny][1] <= dist[p.x][p.y][p.drillCount] + 1) continue;
                    dist[nx][ny][1] = dist[p.x][p.y][p.drillCount] + 1;
                    q.add(new Point(nx, ny, 1));
                } else if (map[nx][ny]==0) {
                    //벽 안부셔도 되는 경우
                    if (dist[nx][ny][p.drillCount] <= dist[p.x][p.y][p.drillCount] + 1) continue;
                    dist[nx][ny][p.drillCount] = dist[p.x][p.y][p.drillCount] + 1;
                    q.add(new Point(nx, ny, p.drillCount));
                }

            }

        }

    }

    public static boolean inRange(int x, int y) {
        if (x > N - 1 || y > M - 1 || x < 0 || y < 0) return false;
        return true;
    }
}