import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;   //집합의 개수
    static int M;   //연산의 개수
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];


        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(op==0){
                union(x,y);
            }else{
                x = find(x);
                y = find(y);
                if(x==y){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y) return;

        if(x<y) parent[y] = x;
        else parent[x] = y;
    }

    public static int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
}