import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H;
    static int W;
    static int[] height;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        height = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W - 1; i++) {
            int left = 0;
            int right = 0;

            //내 왼쪽에 벽 있는가?
            for (int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            //내 오른쪽에 벽 있는가?
            for (int j = i + 1; j < W; j++) {
                right = Math.max(height[j], right);
            }

            //만약에 내 오른쪽 왼쪽에 벽이 없다? 못찬다.
            if (left == 0 || right == 0) continue;

            //벽이 나보다 작다? 못찬다
            if (left <= height[i] || right <= height[i]) continue;

            //이제 물 고일 수 있음.
            int diff = Math.min(left, right) - height[i];
            result += diff;


        }

        System.out.println(result);
    }
}