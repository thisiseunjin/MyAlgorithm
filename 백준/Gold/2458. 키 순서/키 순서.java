import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dist;
    static final int INF = 500 * 500;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dist[i], INF);
        }

//        for (int i = 0; i < N + 1; i++) {
//            dist[i][i] = 0;
//        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            dist[from][to] = 1;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i < N+1; i++) {
            boolean flag =false;
            for (int j = 1; j < N+1; j++) {
                if(i==j) continue;
                if(dist[i][j]>=INF&&dist[j][i]>=INF){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }


        System.out.println(result);


//        for (int i = 1; i < N+1; i++) {
//            for (int j = 1; j < N+1; j++) {
//                System.out.print(dist[i][j]+" ");
//
//            }
//            System.out.println();
//        }
    }
}