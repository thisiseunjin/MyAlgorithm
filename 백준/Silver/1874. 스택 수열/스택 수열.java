import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder result = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder after = new StringBuilder();
    static Queue<Integer> queue = new ArrayDeque<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int curIdx = 1;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            in.append(input).append(" ");
            queue.add(input);
        }

        while (!queue.isEmpty()) {
            int num = queue.peek();

            if (!stack.isEmpty()&& stack.peek() == num) {
                queue.poll();
                int p = stack.pop();
//                System.out.println(p);
                after.append(p).append(" ");
                result.append("-").append("\n");
                continue;
            }
            if(curIdx>N) {
                queue.poll();
                continue;
            }
            stack.push(curIdx++);
            result.append("+\n");
        }

        if(in.toString().equals(after.toString())){
            System.out.println(result);
        }else System.out.println("NO");
/*        System.out.println(stack.toString());
        System.out.println(in);
        System.out.println(after);*/
//        System.out.println(result);

    }

}