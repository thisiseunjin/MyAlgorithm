import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] depth; //각 문제집 별 depth설정
    static ArrayList<Integer>[] info;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        depth = new int[N + 1];

        info = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            info[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   //B번 문제보다 먼저 풀어야 한다.
            int b = Integer.parseInt(st.nextToken());

            info[a].add(b);
            depth[b]++;
        }

        //가능하면 쉬운 문제부터 풀어야 하기 때문에 우선순위큐에 넣어준다.
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i < N+1; i++) {
            if (depth[i] > 0) continue;
            q.add(i);
        }

        while (!q.isEmpty()) {
            int n = q.poll();

            //출력할 결과물에 추가 해준다.
            sb.append(n).append(" ");

            for (int i = 0; i < info[n].size(); i++) {
                int m = info[n].get(i);
                depth[m]--;
                if (depth[m] > 0) continue;
                q.add(m);
            }
        }

        System.out.println(sb);
    }

}