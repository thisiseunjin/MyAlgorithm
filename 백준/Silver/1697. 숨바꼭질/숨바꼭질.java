import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static boolean[] isVisited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        int cnt = 0;
        int[] dx = {1, -1};

        Queue<Point> q = new ArrayDeque<>();
        isVisited[N] = true;
        q.add(new Point(N, 0));
        while (!q.isEmpty()) {
            //1. 현재 정점을 뽑는다.
            Point p = q.poll();
            if (p.x == K) {
                return p.depth;
            }

            //순간 이동을 안하는 경우
            for (int i = 0; i < 2; i++) {
                int nx = p.x + dx[i];
                if (!inRange(nx)) continue;  //범위를 벗어나면? 못간다.
                if (isVisited[nx]) continue; //이미 방문했으면? 굳이?
                isVisited[nx] = true;
                q.add(new Point(nx, p.depth + 1));
//                isVisited[nx] = false;
            }

            //순간 이동을 하는 경우
            int nx = p.x * 2;
            if (!inRange(nx)) continue;
            if (isVisited[nx]) continue;
            isVisited[nx] = true;
            q.add(new Point(nx, p.depth + 1));
//            isVisited[nx] = false;


        }


        return cnt;
    }

    static boolean inRange(int x) {
        if (x < 0 || x > 100_000) return false;
        return true;
    }

    static class Point {
        int x;
        int depth;

        public Point(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }

    }
}