import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] info;
    static StringBuilder sb;
    static long result = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        info = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info);

        for (int i = 0; i < N - 2; i++) {
            binarySearch(i);
        }

        System.out.println(sb);


    }

    public static void binarySearch(int idx) {
        int left = idx + 1;
        int right = N - 1;

        while (left < right) {
            long sum = (long) info[idx] + info[left] + info[right];

            if (Math.abs(sum) < result) {
                result = Math.abs(sum);
                sb = new StringBuilder();
                sb.append(info[idx]).append(" ").append(info[left]).append(" ").append(info[right]);
            }

            if (sum == 0) {
                sb = new StringBuilder();
                sb.append(info[idx]).append(" ").append(info[left]).append(" ").append(info[right]);
                break;
            }

            if (sum > 0) {
                //0보다 크면? right를 줄인다.
                right -= 1;
            } else {
                left += 1;
            }
        }

    }
}