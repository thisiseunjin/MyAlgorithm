import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //처음 생기는 구름
        q.add(new int[]{N - 1, 0});
        q.add(new int[]{N - 1, 1});
        q.add(new int[]{N - 2, 0});
        q.add(new int[]{N - 2, 1});

        for (int i = 0; i < M; i++) {
            isVisited = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            step12(d, s);
            step34();
            step5();
        }


        System.out.println(getSum());
    }

    public static void step12(int d, int s) {
        //모든 구름이 이동 후 이동된 자리에 비내림
        for (int[] cloud : q) {
            cloud[0] = (N + cloud[0] + dx[d] * (s % N)) % N;
            cloud[1] = (N + cloud[1] + dy[d] * (s % N)) % N;

            map[cloud[0]][cloud[1]]++;
        }
    }

    public static void step34() {

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int count = 0;

            isVisited[cur[0]][cur[1]] = true;
            for (int i = 1; i < 8; i += 2) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;
                ;
                if (map[nx][ny] < 1) continue;
                count++;
            }

            map[cur[0]][cur[1]] += count;

        }

    }

    public static void step5() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;
                if (map[i][j] < 2) continue;

                map[i][j] -= 2;
                q.add(new int[]{i, j});
            }
        }
    }

    public static int getSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }

        return sum;
    }


    public static boolean inRange(int x, int y) {
        if (x > N - 1 || y > N - 1 || x < 0 || y < 0) return false;
        return true;
    }

}