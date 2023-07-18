import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = 0;

    static class Time implements Comparable<Time> {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    static PriorityQueue<Integer> endList = new PriorityQueue<>();
    static PriorityQueue<Time> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.add(new Time(start, end));
        }

        //일단 첫 번째 수업을 시작한다.
        Time first = queue.poll();
        endList.add(first.end);

        while (!queue.isEmpty()) {
            Time cur = queue.poll();
            int lastTime = endList.peek();

            if(cur.start>=lastTime){
                //만약 시작 시간이 최근에 끝난 타임뒤의 일이라면?
                // 강의실을 다시 만들지 않아도 된다.
                endList.poll();
                endList.add(cur.end);
            }else{
                //하지만 동시에 시작 되어야 하는 일이라면?? 동시에 시작해야지...
                result+=1;
                endList.add(cur.end);
            }
        }

        System.out.println(result+1);

    }

}