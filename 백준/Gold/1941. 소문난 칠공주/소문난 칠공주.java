import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N = 5;
    static char[][] map = new char[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] isVisited = new boolean[5][5];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);
                map[i][j] = ch;
            }
        }

        dfs(0, 0, 0);

        System.out.println(result);
    }

    //1. 여학생들의 조합을 일단 먼저 만는다.
    public static void dfs(int start, int depth, int cnt) {
        if (cnt > 3) return;    //도연이네가 더 많음.

        if (depth == 7) {
            //종료조건
            bfs(start - 1);
            return;
        }

        for (int i = start; i < N * N; i++) {
            isVisited[i / N][i % N] = true; //방문 체크 한다
            dfs(i + 1, depth + 1, map[i / N][i % N] == 'Y' ? cnt + 1 : cnt);
            isVisited[i / N][i % N] = false;    //방문 체크 해제
        }
    }


    //2. 가능한 조합인지 확인작업 진행.
    public static void bfs(int start) {
        boolean[][] isSelected = new boolean[N][N];

        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(start / N, start % N));
        isSelected[start / N][start % N] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (!inRange(nx, ny)) continue; //범위 이상
                if (isSelected[nx][ny]) continue;    //이미 체크한 그것
                if (!isVisited[nx][ny]) continue;    //내 조합에 없는 그것

                q.add(new Point(nx, ny));
                isSelected[nx][ny] = true;
            }
        }

        if (cnt == 7) result++;


    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static boolean inRange(int x, int y) {
        return x <= N - 1 && y <= N - 1 && x >= 0 && y >= 0;
    }


}