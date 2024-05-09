import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;   //음악 프로그램의 수
    static int M;   //PD의 수
    static int[] depth;
    static ArrayList<Integer>[] list;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        depth = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) continue;

            int pre = Integer.parseInt(st.nextToken());
            for (int j = 1; j < n; j++) {
                int m = Integer.parseInt(st.nextToken());
                list[pre].add(m);
                depth[m]++;
                pre = m;
            }
        }

        //위상정렬 시작
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (depth[i] > 0) continue;  //depth가 0이라는 뜻은 아직 정렬할 수 없는 상태임을 의미한다.
            q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append("\n");
            cnt++;

            //나와 연결된 애들을 다 --해준다
            for (int i = 0; i < list[now].size(); i++) {
                int n = list[now].get(i);
                depth[n] -= 1;

                if (depth[n] > 0) continue;

                q.add(n);
            }
        }

        System.out.println(cnt<N?0:sb);

    }
}