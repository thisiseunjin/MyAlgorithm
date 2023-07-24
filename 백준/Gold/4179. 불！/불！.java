import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //탈출 여부 & 탈출 시간
    static int R, C;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = (int) 1e9;
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int x, y, time;
        boolean isFire;

        public Point(int x, int y, int time, boolean isFire) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.isFire = isFire;
        }

    }

    static char[][] map;    //#:벽, .:지나갈 수 있는 공간, J:지훈이의 초기 위치, F:불이 난 공간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());   //미로의 행의 개수
        C = Integer.parseInt(st.nextToken());   //미로의 열의 개수

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'F') q.add(new Point(i, j, 0, true));
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') {
                    q.add(new Point(i, j, 0, false));
                    map[i][j] = '.';
                }
            }
        }

        bfs();

        System.out.println(result == (int) 1e9 ? "IMPOSSIBLE" : result);
    }

    public static void bfs() {
        boolean[][] isVisited = new boolean[R][C];
        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.isFire) {
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!inRange(nx, ny)) continue;
                    if (map[nx][ny] != '.') continue;

                    map[nx][ny] = 'F';

                    q.add(new Point(nx, ny, cur.time + 1, true));
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!inRange(nx, ny)) {

                        result = Math.min(result, cur.time + 1);
                        continue;
                    }
                    if (map[nx][ny] != '.') continue;
                    if (isVisited[nx][ny]) continue;

                    isVisited[nx][ny] = true;
                    q.add(new Point(nx, ny, cur.time + 1, false));
                }
            }

        }
    }

    public static boolean inRange(int x, int y) {
        if (x > R - 1 || y > C - 1 || x < 0 || y < 0) return false;
        return true;
    }

}