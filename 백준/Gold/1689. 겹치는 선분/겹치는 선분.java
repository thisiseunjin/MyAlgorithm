import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    static int N;
    static int max;

    static class Point implements Comparable<Point> {
        int point, value;

        public Point(int point, int value) {
            this.point = point;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            if (this.point != o.point)
                return this.point - o.point;
            else return this.value - o.value;
        }
    }

    static ArrayList<Point> list = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Point(start, +1));  //시작점
            list.add(new Point(end, -1));    //끝점
        }

        Collections.sort(list);


        for (int i = 0; i < N * 2; i++) {
            int point = list.get(i).point;
            int value = list.get(i).value;

            // 적혀있는 가중치를 전부 더해줍니다.
            //System.out.println(sum);
            sum += value;
            result = Math.max(sum, result);
        }

        // x = k에 겹쳐져 있는 선분의 수 = 2
        System.out.println(result);

    }
}