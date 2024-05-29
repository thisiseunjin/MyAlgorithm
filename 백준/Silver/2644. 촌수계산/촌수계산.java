import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;   //사람의 수
    static int p1, p2;  //촌수를 구해야 하는 사람 의수
    static int M;   //관계의 수
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[p].add(c);
            list[c].add(p);
        }


        System.out.println(bfs());


    }

    public static int bfs() {
        boolean[] isVisited = new boolean[N + 1];
        int result = -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{p1, 0});
        isVisited[p1] = true;

        while (!q.isEmpty()) {
            int[] info = q.poll();

            if (info[0] == p2) {
                result = info[1];
                break;
            }

            for (int p : list[info[0]]) {
                if (isVisited[p]) continue;  //이미 방문한 적이 있으면 건너뛴다.
                isVisited[p] = true;
                q.add(new int[]{p, info[1] + 1});
            }
        }

        return result;
    }
}