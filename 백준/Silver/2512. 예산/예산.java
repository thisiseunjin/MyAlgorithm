import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //정해진 총액 이하에서 가능한 최대의 예산 배정한다.
    /*
        [규칙]
        1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정함.
        2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산 요청에는 모두 상한액을 배정. 이하는 그대로 배정
     */
    static int[] budget;
    static int limit;
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //걍 이분탐색 때리기
        N = Integer.parseInt(br.readLine());
        budget = new int[N];
        st = new StringTokenizer(br.readLine());
        int right = 0;
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            right = Math.max(budget[i], right);
        }
        limit = Integer.parseInt(br.readLine());

        int left = 0;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (isPossible(mid)) {
                //가능 하다면? 금액 늘려봄
//                System.out.println(mid + "원으로 가능!");
                left = mid + 1;
                result = Math.max(result, mid);
            } else {
                //불가능 하다면? 줄여봄
                right = mid - 1;
            }
        }

        System.out.println(result);

    }

    public static boolean isPossible(int l) {
        //상한선이 l일때 예산 배정 가능한지
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(budget[i], l);
        }

//        System.out.println(l + "일때 총합은 " + sum);

        return sum <= limit;
    }
}