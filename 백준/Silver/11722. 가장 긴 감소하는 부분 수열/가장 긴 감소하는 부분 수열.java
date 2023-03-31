import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int arr[];
    static int dp[];
    static int maxLength=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            //내 앞에서 나보다 큰애들 중에서 가장 큰 애를 찾는다.
            int pre = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i]<arr[j]){
                    pre = Math.max(pre, dp[j]);
                }
            }
            dp[i] = pre+1;
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);
    }
}