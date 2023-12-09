import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int G;   //게이트개수 게이트는 1~G까지 있다.
    static int P;   //비행기의 수
    static int count=0;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());

        parents = new int[G+1];

        for (int i = 0; i < G+1; i++) {
            parents[i] = i;
        }

        P = Integer.parseInt(br.readLine());

        boolean flag = false;
        for (int i = 0; i < P; i++) {
            int  g = Integer.parseInt(br.readLine());
            int p = find(g);
            if(find(p)==0) flag = true;




            if(!flag) {
                count++;
                union(p-1,p);
            }
        }

        System.out.println(count);

    }

    public static int find(int a){
        //a의 부모를 찾는다.
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b){
        //작은 것을 부모로!
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB) return;
        if(rootA<rootB){
            parents[rootB] = parents[rootA];
        }else{
            parents[rootA] = parents[rootB];
        }
    }
}