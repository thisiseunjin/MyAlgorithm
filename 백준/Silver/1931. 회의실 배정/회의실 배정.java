import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int time;
    static PriorityQueue<Meeting> q = new PriorityQueue<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    //총 회의의 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            q.add(new Meeting(s, e));
        }


        while (!q.isEmpty()) {
            Meeting m = q.poll();

//            System.out.println(m);

            if (m.start < time) continue;
            result++;
            time = m.end;
        }

        System.out.println(result);

    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) return this.start - o.start;
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}