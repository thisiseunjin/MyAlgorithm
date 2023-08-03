import java.io.*;
import java.util.*;

public class Main {
    static final int  INF = (int)1e9;
    static int N,E;
    static int dp[];
    static class Point{
        int node, adj;

        public Point(int node, int adj) {
            this.node = node;
            this.adj = adj;
        }
    }
    static int startToV1 = (int)1e9;
    static int startToV2 = (int)1e9;
    static int V1ToV2 =  (int)1e9;
    static int V2ToV1= (int)1e9;
    static int V2ToEnd =  (int)1e9;
    static int V1ToEnd =  (int)1e9;
    static int result = (int)1e9;

    public static ArrayList<Point>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        list = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());

            list[v1].add(new Point(v2,adj));
            list[v2].add(new Point(v1,adj));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        if(E==0) {
            System.out.println(-1);
            return;
        }


        result = Math.min(dijk(1,v2)+dijk(v2,v1)+dijk(v1,N), dijk(1,v1)+dijk(v1,v2)+dijk(v2,N));

        System.out.println(result>=INF?-1:result);


    }

    public static int dijk(int start, int end){

        //start에서 시작해서 end까지 가는 최단경로
        if(start==end) return 0;
        dp = new int[N+1];
        Arrays.fill(dp,INF);
        Queue<Point> q = new ArrayDeque<>();
        dp[start] = 0;
        q.add(new Point(start,0));  //일단 첫 시작 넣어줌


        while (!q.isEmpty()){
            Point point = q.poll();
            int cur = point.node;
            int adj = point.adj;

            dp[cur] = Math.min(dp[cur],adj);


            for (Point p: list[cur]) {
                int next = p.node;
                int nextDist = p.adj;

                if(dp[next]>nextDist+dp[cur]){
                    dp[next] = nextDist+dp[cur];
                    q.add(new Point(next, dp[next]));
                }
            }
        }

        return dp[end];

    }

}