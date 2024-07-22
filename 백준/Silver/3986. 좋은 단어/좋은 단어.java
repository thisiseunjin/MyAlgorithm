import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int result = 0;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            //스택 초기화 하기
            stack.clear();

            if (isGoodWord(str)) result++;

        }

        System.out.println(result);
    }

    public static boolean isGoodWord(String str) {
        for (int i = 0; i < str.length(); i++) {

            //만약 stack이 비어따?
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
                continue;
            }

            //스택의 위에꺼가 내꺼당? 뺀당!
            if (stack.peek() == str.charAt(i)) {
                stack.pop();
                continue;
            }

            //내꺼가 아니당?
            stack.push(str.charAt(i));
        }

        return stack.empty();
    }
}