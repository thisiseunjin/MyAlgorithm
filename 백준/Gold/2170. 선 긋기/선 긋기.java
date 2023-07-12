import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result;
    static ArrayList<Point> list = new ArrayList<>();
    static class Point implements Comparable<Point>{
        int start, end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            if(this.start==o.start){
                return this.end-o.end;
            }else{
                return this.start-o.start;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Point(s,e));
        }

        Collections.sort(list);

//        System.out.println(list.toString());

        int start,end;

        start = list.get(0).start;
        end = list.get(0).end;
        result = end-start;
//        System.out.println("start! "+result);

        for (int i = 1; i < N; i++) {
            int nextStart = list.get(i).start;
            int nextEnd = list.get(i).end;

//            System.out.println(list.get(i));

            if(nextStart>end){
                //다른 선분으로 넘어갈때
                result += (nextEnd-nextStart);
                start = nextStart;
                end = nextEnd;

            }else {
                //현재 선분에 완전히 포함된 경우
                if(nextEnd<end) continue;
                result+= nextEnd-end;
                end = nextEnd;

            }
        }

        System.out.println(result);
    }
}