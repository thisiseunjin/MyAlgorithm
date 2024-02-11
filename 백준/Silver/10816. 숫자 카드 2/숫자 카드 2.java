import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

public class Main {
    static int N;   //가지고 있는 숫자카드의 수
    static int M;   //주어지는 숫자 카드의 수
    static StringBuilder sb;
    static int[] mine;  //상근이가 가지고 있는 숫자카드
    static int[] nums;  //주어지는 숫자들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        mine = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mine[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer,Integer> map = new HashMap();
        M = Integer.parseInt(br.readLine());
        nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            map.put(nums[i],0);
        }

        //상근이가 뭐 가지고 있나 확인 진행
        for (int i = 0; i < N; i++) {
            if(!map.containsKey(mine[i])) continue;

            //가지고 있으면? 더하기 1해주기
            map.replace(mine[i],map.get(mine[i])+1 );
        }

        sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(map.get(nums[i])).append(" ");
        }

        System.out.println(sb);


    }
}