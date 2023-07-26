import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (j == 0) continue;

                map[i][j] += map[i][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
//            System.out.println("=============================== ");
            int sum = 0;
            for (int x = x1; x < x2 + 1; x++) {
                sum += map[x][y2];
//                System.out.println("plus : "+ map[x][y2]);
            }
            if (y1 - 1 >= 0) {

                for (int x = x1; x < x2 + 1; x++) {
                    sum -= map[x][y1 - 1];
//                    System.out.println("minus : "+ map[x][y1-1]);
                }
            }
//            System.out.println("=============================== ");
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }

    public static boolean inRange(int x, int y) {
        if (x > N - 1 || x < 0 || y > N - 1 || y < 0) return false;
        return true;
    }
}