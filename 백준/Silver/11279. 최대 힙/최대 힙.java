import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //1. 배열에 자연수 x를 넣는다
    //2. 가장 큰 값을 출력하고, 제거한다.

    static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 0) {
                q.add(x);
                continue;
            }

            if(q.isEmpty()) sb.append("0\n");
            else sb.append(q.poll()).append("\n");
        }

        System.out.println(sb);
    }
}