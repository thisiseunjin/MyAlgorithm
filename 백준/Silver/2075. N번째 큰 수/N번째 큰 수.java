import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static PriorityQueue<Integer>[] queues;
    static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                q.add(n);
            }
        }

        int res =0;

        for (int i = 0; i < N; i++) {
            res = q.poll();
        }

        System.out.println(res);
    }
}