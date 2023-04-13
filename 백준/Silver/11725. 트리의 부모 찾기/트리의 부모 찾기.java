import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    static boolean isVisited[];
    static int parent[];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        parent = new int[N+1];
        isVisited = new boolean[N+1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        dfs(1);

        for (int i = 2; i < N+1; i++) {
            sb.append(parent[i]+"\n");
        }

        System.out.println(sb);

    }

    public static void dfs(int v) {
        isVisited[v] = true;
//        for (int i = 0; i < list[v].size(); i++) {
//            if (isVisited[list[v].get(i)]) continue;
//
//            dfs(list[v].get(i));
//        }

        for(int vertex : list[v]){
            if(isVisited[vertex]) continue;
            parent[vertex] = v;
            dfs(vertex);
        }
    }


}