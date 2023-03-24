import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer> list[];
    static int result =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);

        }
        //------ 입력 완료! -----------
        bfs();

        System.out.println(result);

    }

    public static void bfs(){
        boolean ischecked[] = new boolean[N+1];
        ischecked[1] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < list[1].size(); i++) {
            queue.add(list[1].get(i));
        }

        while (!queue.isEmpty()){
            int num = queue.poll(); //que에서 값을 꺼낸다.
            if(ischecked[num]) continue;
            ischecked[num] = true;
            result++;
            for (int i = 0; i < list[num].size(); i++) {
                queue.add(list[num].get(i));
            }

        }
    }





}