import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Stack<Integer> stack = new Stack<>();
    static int result = 0;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        heights = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            heights[i] = y;
        }

        for (int i = 0; i < n + 1; i++) {

            //스택이 비어있지 않고 나 보다 낮은게 나오면? 건물 1개 뿅뿅
            while (!stack.isEmpty() && stack.peek() > heights[i]) {
                result++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == heights[i]) continue;

            stack.push(heights[i]);
        }

        System.out.println(result);
    }
}