import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.IntUnaryOperator;

public class Main {
    static int N;   //수열의 크기 A
    static int inputs[];    //수열을 이루고 있는 배열
    static int dp[];
    static int result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        inputs = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        for (int i = 1; i < N+1; i++) { //
            //d[i] = input[i]번째를 가장 마지막으로 하는 증가하는 부분수열이다.
            //1. 내 앞에 나보다 작은 수 중에서 가장 큰 수를 찾는다.
            int minThenMe=0;
            for (int j = 0; j < i; j++) {
                if(inputs[j]<inputs[i]){    //나보다 작은 수를 찾았음!
                    minThenMe = Math.max(minThenMe, dp[j]);
                }
            }
            // 2. 나보다 작은 애 + 내 값
            dp[i] = minThenMe+inputs[i];
            result = Math.max(dp[i],result);
        }

        System.out.println(result);
    }

}