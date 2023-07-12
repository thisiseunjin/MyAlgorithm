import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //pointer 2개는 모두 앞으로 "전진"만 한다.
        int startPoint = 0;
        int endPoint = 0;

        int sum = nums[0]; //해당 구간의 합

        while (endPoint<N) {
            if (sum < M) {
                //합이 더 작다? 더 많이 더해줘야 한다.
                sum += nums[++endPoint];
            }else{
                if(sum==M) count++;
                sum-=nums[startPoint++];
            }

            //f(endPoint==N) break;
        }

        System.out.println(count);

    }
}