import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int K;
    static int V, E;
    static ArrayList<Integer> list[];
    static int isVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for (int test = 0; test < K; test++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());   //정점의 개수
            E = Integer.parseInt(st.nextToken());   //간선의 개수


            list = new ArrayList[V + 1];
            isVisited = new int[V+1];
            for (int i = 0; i < V + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if(u==v) continue;

                list[u].add(v);
                list[v].add(u);
            }

            boolean flag = true;
            for (int i = 1; i < V+1; i++) {

                if(isVisited[i]!=0) continue;
                if(!bfs(i)) {
                    flag = false;
                    break;
                }

            }

            if(flag) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }

    public static boolean bfs(int start){
        //1부터 일단 걍 시작한다.
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        isVisited[start] = 1;

        while (!q.isEmpty()){
            int v = q.poll();
            //System.out.println(v);

            int cur = isVisited[v];

            //연결된 곳을 순회한다.
            for (int i = 0; i < list[v].size(); i++) {
                int next = list[v].get(i);

                if(isVisited[next]==cur) return false;

                if(isVisited[next]==0){
                    isVisited[next] = cur*(-1);
                    q.add(next);
                }

            }
        }

        return true;
    }

}