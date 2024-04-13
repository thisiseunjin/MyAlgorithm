import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;   //반전이후 보일 수 있는 숫자의 최댓값.
    static int K;   //K자리의 수가 LED에 있음
    static int P;   //최대 P개를 반전시킬 수 있음.
    static int X;   //현재 X층임
    static int[] nums;

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        initMap();
        nums = toDigit(X);

//        System.out.println(Arrays.toString(nums));
        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            //1부터 N까지 숫자를 맹글어 본다.
            if (i == X) continue;
            if(isPossible(i)) result++;

        }

        System.out.println(result);

    }

    private static int[] toDigit(int n) {

        int[] digits = new int[K];

        for (int i = K - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }

    private static boolean isPossible(int to) {
        int sum = 0;
        int[] target = toDigit(to);

        for (int i = 0; i < K; i++) {
            int f = nums[i];
            int t = target[i];

            int cnt = Integer.bitCount(hashMap.get(f)^hashMap.get(t));
            sum+=cnt;
            if(sum>P)return false;
        }

        return true;

    }


    private static void initMap() {
        hashMap.put(0, 0b1111110);
        hashMap.put(1, 0b0110000);
        hashMap.put(2, 0b1101101);
        hashMap.put(3, 0b1111001);
        hashMap.put(4, 0b0110011);
        hashMap.put(5, 0b1011011);
        hashMap.put(6, 0b1011111);
        hashMap.put(7, 0b1110000);
        hashMap.put(8, 0b1111111);
        hashMap.put(9, 0b1111011);
    }
}