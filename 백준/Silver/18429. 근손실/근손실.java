import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] weights;
    static boolean[] isSelected;
    static int[] selected;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new int[N];
        isSelected = new boolean[N];
        selected = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(result);


    }

    static void permutation(int cnt) {
        if (cnt == N) {
            if (isPossible()) result++;
            return;
        }

        for (int i = 0; i < N; i++) {

            //이미 선택 되어 있으면? 선택 안한다.
            if (isSelected[i]) continue;

            //선택하고 간다.
            isSelected[i] = true;
            selected[cnt] = i;
            permutation(cnt + 1);

            //선택 해제
            isSelected[i] = false;
        }
    }

    static boolean isPossible() {
        int cur = 500;
        for (int i = 0; i < N; i++) {
            cur += (weights[selected[i]] - K);
            if (cur < 500) return false;
        }

        return true;
    }


}