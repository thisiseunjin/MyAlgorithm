import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;   //사람의 수
    static int M;   //친구 관계의 수
    static ArrayList<Integer>[] list;
    static boolean[] isChecked;
    static int count = 0;
    static boolean flag = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isChecked = new boolean[N];
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        //1. 일단 관계 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            //친구 관계는 양방향이다.
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        //2. 방문체크 시작~!
        for (int i = 0; i < N; i++) {
            isChecked = new boolean[N];
            isChecked[i] = true;
            go(i,0);
        }


//        if(flag) System.out.println(1);
//        else System.out.println(0);
        System.out.println(0);

    }

    static public void go(int start, int depth) {
        if(depth==4){
            System.out.println(1);
            System.exit(0);
        }
        for (int cur : list[start]) {
            if (isChecked[cur]) continue;
            isChecked[cur] = true;
            go(cur, depth+1);
            isChecked[cur] = false;
        }
    }



}