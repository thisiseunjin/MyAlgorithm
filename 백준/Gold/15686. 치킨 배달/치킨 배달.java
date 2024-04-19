import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Point> homeList = new ArrayList<>();
    static ArrayList<Point> storeList = new ArrayList<>();
    static int N;
    static int M;
    static int[] selected;
    static int K;
    static int H;
    static ArrayList<Info>[] distInfo;
    static int result = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0) continue;
                if (n == 1) homeList.add(new Point(i, j));
                else storeList.add(new Point(i, j));
            }
        }

        H = homeList.size();
        distInfo = new ArrayList[H];
        for (int i = 0; i < H; i++) {
            distInfo[i] = new ArrayList<>();
        }

        K = storeList.size() - M;
        selected = new int[K];

        init();

        comb(0, 0);

        System.out.println(result);


    }

    public static void init() {
        for (int i = 0; i < H; i++) {
            //각 집에서 모든 치킨 집까지 거리를 계산
            Point p1 = homeList.get(i);
            for (int j = 0; j < storeList.size(); j++) {
                Point p2 = storeList.get(j);
                distInfo[i].add(new Info(j, getDist(p1, p2)));
            }
        }

        for (int i = 0; i < homeList.size(); i++) {
            Collections.sort(distInfo[i]);
        }
    }

    private static void comb(int cnt, int start) {
        if (cnt == K) {
            //종료 조건
            result = Math.min(result, calcTotal());
            return;
        }

        for (int i = start; i < storeList.size(); i++) {
            selected[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static int calcTotal() {
        int sum = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i : selected) {
            set.add(i);
        }

        //각 집마다 최소 치킨 거리
        for (int i = 0; i < H; i++) {
            for (Info info : distInfo[i]) {
                if (set.contains(info.idx)) continue;
                sum += info.dist;
                break;
            }
        }
        return sum;
    }

    private static int getDist(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Info implements Comparable<Info> {
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Info o) {
            return this.dist - o.dist;
        }
    }


}