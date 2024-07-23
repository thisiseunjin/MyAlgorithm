import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Deque<Integer> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String operation = st.nextToken();

            switch (operation) {
                case "push": {
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                }

                case "pop": {
                    sb.append(!q.isEmpty() ? q.pollFirst() : -1).append("\n");
                    break;
                }

                case "size": {
                    sb.append(q.size()).append("\n");
                    break;
                }

                case "empty": {
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                }

                case "front": {
                    sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
                    break;
                }

                case "back": {
                    sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
                    break;
                }
            }


        }

        System.out.println(sb);
    }
}