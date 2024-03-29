import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] liquids;
    static int result = 2_000_000_001;
    static int result1;
    static int result2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        liquids = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;


        while (left < right) {
            int sum = liquids[left] + liquids[right];
//            if (sum == 0) {
//                result = 0;
//                break;
//            }

            if(result>=Math.abs(sum)){
                result = Math.abs(sum);
                result1 = liquids[left];
                result2 = liquids[right];
            }
            if (sum < 0) {
                //음수 이면? 더 큰거를 더해야 한다.
                left++;
            } else {
                //양수이면? 더 작은걸 더해볼까?
                right--;
            }
        }

        System.out.println(result1 + " "+result2);

    }
}