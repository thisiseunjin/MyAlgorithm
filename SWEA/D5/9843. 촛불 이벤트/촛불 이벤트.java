import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int T;
    static StringBuilder sb = new StringBuilder();
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test = 1; test < T + 1; test++) {
            sb.append("#" + test).append(" ");
            N = Long.parseLong(br.readLine());

            long left = 1;
            long right = 10000000000L;
            long result = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                long val = mid * (mid + 1) / 2;

                if (N >= val) {
                    //값이 될 확률이 있다. 늘려준다.
                    result = Math.max(mid, result);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            long val = result * (result + 1) / 2;
            if (N != val) {
                result = -1;
            }

            sb.append((int)result + "\n");
        }

        System.out.print(sb);
    }
}