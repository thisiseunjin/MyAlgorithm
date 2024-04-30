import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Point> list = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new Point(x, h));
        }

        list.sort(Comparator.comparing(Point::getX));

        Point high = list.get(0);
        int highIdx = 0;


        for (int i = 1; i < list.size(); i++) {
            Point p = list.get(i);
            if (high.height > p.height) continue;
            sum += Math.abs(p.x - high.x) * high.height;
            high = p;
            highIdx = i;
        }

        high = list.get(list.size() - 1);
        for (int i = 1; i < list.size() - highIdx; i++) {
            Point p = list.get(list.size() - 1 - i);
            if (high.height > p.height) continue;
            sum += Math.abs(p.x - high.x) * high.height;
            high = p;
        }

        sum+=list.get(highIdx).height;

        System.out.println(sum);

    }

    static class Point {
        int x;
        int height;

        public Point(int x, int height) {
            this.x = x;
            this.height = height;
        }

        public int getX() {
            return x;
        }
    }
}