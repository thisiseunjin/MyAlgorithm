import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;   //섬의 개수
    static int M;   //다리의 개수
    static int result = 0;
    static ArrayList<Bridge>[] list;
    static boolean[] isVisited;
    static int to, from;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            list[v1].add(new Bridge(v2, limit));
            list[v2].add(new Bridge(v1, limit));
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());


        int left = 0;
        int right = 1_000_000_000;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            if (isPossible(mid)) {
                result = Math.max(mid, result);
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        System.out.println(result);

    }

    static boolean isPossible(int w) {
        isVisited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        q.add(from);
        isVisited[from] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            if (v == to) {
                return true;
            }

            //해당 정점에서 움직일 수 있는 곳이 있을까?
            for (int i = 0; i < list[v].size(); i++) {
                Bridge bridge = list[v].get(i);

                if (bridge.limit < w) continue;
                if (isVisited[bridge.v]) continue;
                isVisited[bridge.v] = true;
                q.add(bridge.v);
            }
        }

        return false;
    }


    static class Bridge {
        int v;
        int limit;

        public Bridge(int v, int limit) {
            this.v = v;
            this.limit = limit;
        }
    }
}