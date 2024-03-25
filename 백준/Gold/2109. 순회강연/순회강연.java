import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Lecture> q = new PriorityQueue<>();
    static int result;
    static int MAX_DATE;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            MAX_DATE = Math.max(d, MAX_DATE);
            q.add(new Lecture(p, d));
        }

        isSelected = new boolean[MAX_DATE + 1];

        while (!q.isEmpty()) {
            Lecture l = q.poll();

            //만약 d가 차있지 않으면?
            if (!isSelected[l.date]) {
                //그냥 강의 간다.
                result += l.pay;
                isSelected[l.date] = true;
                continue;
            } else {
                //만약 차 있으면? 내 앞이 비었는지 확인해본다.
                for (int i = l.date-1; i >0; i--) {
                    if (isSelected[i]) continue;
                    result += l.pay;
                    isSelected[i] = true;
                    break;
                }
            }
        }

        System.out.println(result);
    }


    static class Lecture implements Comparable<Lecture> {
        int pay;
        int date;

        public Lecture(int pay, int date) {
            this.pay = pay;
            this.date = date;
        }

        @Override
        public int compareTo(Lecture o) {
            if (o.pay == this.pay) return this.date - o.date;
            else return o.pay - this.pay;
//            return o.pay - this.pay;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "pay=" + pay +
                    ", date=" + date +
                    '}';
        }
    }
}