import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int tomatoCount;
    static int emptyCount;
    static int M, N, H;
    static int[][][] boxes;

    static class Tomato {
        int x, y, z, depth;

        public Tomato(int x, int y, int z, int depth) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Tomato[" + "x=" + x + ", y=" + y + ", z=" + z + ", depth=" + depth + ']';
        }
    }

    static int resultTime;

    //탐색을 위한 방향 설정
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static ArrayList<Tomato> tomatos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    // 0:익지 않은 토마토, 1:익은 토마토, -1: 토마토가 없는 자리
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (boxes[i][j][k] == 1) tomatos.add(new Tomato(i, j, k, 0));
                    if(boxes[i][j][k]==-1) emptyCount++;
                }
            }
        }
        //tomatos안에는 depth가 0인 토마토가 들어가있다.

        if (tomatos.size()+emptyCount == (H * N * M)) {
            System.out.println(0);
            return;
        }
        bfs();
        //System.out.println(emptyCount);
        //System.out.println(tomatoCount + "  "+H*N*M);
        System.out.println(allRipe()?resultTime:-1);

        //System.out.println(resultTime == 0 ? -1 : resultTime);

    }

    public static void bfs() {
        Queue<Tomato> queue = new ArrayDeque<>();
        for (int i = 0; i < tomatos.size(); i++) {
            queue.add(tomatos.get(i));
        }

//        System.out.println(queue.toString());

        while (!queue.isEmpty()) {
            Tomato cur = queue.poll();
            tomatoCount++;
            resultTime = cur.depth;
            for (int i = 0; i < 6; i++) {
//                System.out.println(queue.toString());
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];
                int ntime = cur.depth + 1;
                if (!isRange(nx, ny, nz)) continue;
                if (boxes[nx][ny][nz] != 0) continue;
                boxes[nx][ny][nz] = 1;
                //tomatoCount++;
//                System.out.println(ntime);
                queue.add(new Tomato(nx, ny, nz, ntime));
            }
        }
    }

    public static boolean isRange(int x, int y, int z) {
        if (x >= H || x < 0 || y >= N || y < 0 || z >= M || z < 0)
            return false;

        return true;
    }

    public static boolean allRipe() {
        if (tomatoCount+emptyCount == H * M * N) return true;
        return false;
    }


}