import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int K;
    static int[] stones;
    static double result = 0.0;
    static int allCount = 0;
    static double[][] dp ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        M = Integer.parseInt(br.readLine());
        stones = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
            allCount += stones[i];
        }

        K = Integer.parseInt(br.readLine());

//        if (M == 1 || K == 1) {
//            System.out.println("1.0");
//            return;
//        }

        dp = new double[allCount+1][allCount+1];

        for (int i = 0; i < allCount+1; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < allCount+1; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            dp[0][i] = 1;
        }

        double all = comb(allCount,K);
        int same = 0;

        for (int i = 0; i < M; i++) {
            if(stones[i]<K) continue;
            result+=comb(stones[i],K)/all;
        }


        //result = (double) same/(double) all;
        System.out.println(result);

    }

    public static double comb(int n, int k) {
        if (dp[n][k] > 0) return dp[n][k];
        return dp[n][k] = comb(n-1,k-1) + comb(n-1,k);
    }
}