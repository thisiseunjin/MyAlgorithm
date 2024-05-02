import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;   //지나가는 트럭의 수
    static int W;   //동시에 올라가는 트럭의 수
    static int L;   //다리의 최대하중
    static Queue<Integer> info = new ArrayDeque<>();
    static int time;
    static Queue<Integer> q = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            info.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < W; i++) {
            q.add(0);
            //일단 다리에 무엇인가가 다 차 있다고 가정한다.
        }

        int sum = 0;
        while (!q.isEmpty()) {
            time++;
            //앞에 꺼를 먼저 뺀다.
            sum -= q.poll();

            //만약 무게의 합(sum)이 L을 넘기지 않는다면? 다음 차를 넣어준다.

            if (info.isEmpty()) continue;
            //그런데 넘을 경우는??
            if (sum+info.peek() > L) {
                q.add(0);
                continue;
            }
            sum+=info.peek();
            q.add(info.poll());

        }


        System.out.println(time);
    }
}