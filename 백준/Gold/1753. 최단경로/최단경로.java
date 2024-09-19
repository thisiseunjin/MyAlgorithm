import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static int[] dist;
    static ArrayList[] list;
    static boolean[] isVisited;
    static int start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1];
        Arrays.fill(dist, (int) 1e9);

        isVisited = new boolean[V + 1];

        list = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<int[]>();
        }

        start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            list[start].add(new int[]{end, adj});
        }

        dijkstra();

        for (int i = 1; i < V + 1; i++) {
            System.out.println(dist[i] == (int) 1e9 ? "INF" : dist[i]);
        }
    }

    public static void dijkstra() {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        q.add(new int[]{start, 0});
        dist[start] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curX = now[0];
            int curAdj = now[1];

            if (isVisited[curX]) continue;

            //갔다고 표시해준다.
            isVisited[curX] = true;

            //내 위치에서 갈 수 있는 모든 경로를 탐색
            for (int i = 0; i < list[curX].size(); i++) {
                int[] next = (int[]) list[curX].get(i);
                int nx = next[0];

                if (dist[nx] <= curAdj + next[1]) {
                    continue;
                }

                dist[nx] = curAdj + next[1];
                q.add(new int[]{nx, curAdj + next[1]});
            }
        }

    }


}