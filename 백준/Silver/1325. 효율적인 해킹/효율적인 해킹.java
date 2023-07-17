import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int maxCount = 0;
    static int count = 0;
    static int results[];
    static ArrayList<Integer> resultList = new ArrayList<>();
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 기본 로직 : 각 정점을 dfs로 순회하여 가장 많이 순회할 수 있는 정점을 찾는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        results = new int[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        //양방향 그래프 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
        }

        for (int i = 1; i < N + 1; i++) {
            isVisited = new boolean[N + 1];
            bfs(i);
        }

        for (int i = 1; i < N + 1; i++) {
            if (results[i] > maxCount) maxCount = results[i];
        }


        for (int i = 1; i < N + 1; i++) {
            if (results[i] == maxCount)
                System.out.print(i + " ");
        }

    }

    public static void bfs(int start) {

        Queue<Integer> q = new ArrayDeque<>();

        // 방문체크
        isVisited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            //연결된 곳을 순회한다.
            for (int next : list[v]) {
                if(isVisited[next]) continue;
                results[next]++;
                isVisited[next] = true;
                q.add(next);
            }

        }

    }
}