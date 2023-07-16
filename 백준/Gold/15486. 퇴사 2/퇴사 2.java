import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static int max  =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N+2];




        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());
            max = Math.max(max, dp[i]);

            int nextDay = i+time;
            if(nextDay>N+1) {
                continue;
            }


            dp[nextDay] = Math.max(dp[nextDay], max+adj);

        }

        //System.out.println(Arrays.toString(dp));
        System.out.println(Math.max(max, dp[N+1]));

    }
}