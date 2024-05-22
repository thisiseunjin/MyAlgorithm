import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;   //주차 공간의 수
    static int M;   //오늘 들어올 차량의 수
    static int[] pay;   //각 주차 공간의 단위 무게 당 요금
    static int[] weight;    //차량의 무게 정보
    static int[] info;   //주차 공간의 정보
    static int[] location;
    static Queue<Integer> q = new ArrayDeque<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pay = new int[N];
        info = new int[N];
        location = new int[M + 1];
        weight = new int[M + 1];

        Arrays.fill(info, -1);

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            pay[i] = n;
        }

        for (int i = 1; i < M + 1; i++) {
            int n = Integer.parseInt(br.readLine());
            weight[i] = n;
        }

        for (int i = 0; i < M * 2; i++) {
            int car = Integer.parseInt(br.readLine());

            if (car > 0) {
//                System.out.println(car + " 주차!");
                parking(car);
            } else {
//                System.out.println(car + " 출차!");
                out(car);
            }
        }

        System.out.println(result);


    }

    public static void parking(int car) {

        int l = findParking();

        //근데 만약 주차 자리가 없다면?
        if (l == -1) {
            q.add(car);
            return;
        }

        info[l] = car;
        location[car] = l;
    }

    public static void out(int car) {
        int c = Math.abs(car);

        int l = location[c];
        info[l] = -1;
        result += (weight[c] * pay[l]);

        if (!q.isEmpty()) {
            int qc = q.poll();
            location[qc] = l;
            info[l] = qc;
        }
    }

    public static int findParking() {
        for (int i = 0; i < N; i++) {
            if (info[i] == -1) return i;
        }

        return -1;
    }

}