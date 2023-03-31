import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static int cheeseCount = 0;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int resultTime = 0;
    static int beforeCnt = 0;
    static boolean isVisited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    cheeseCount++;
            }
        }
        //======== 치즈의 위치를 저장 완료 ==============

        while (cheeseCount != 0) {
            resultTime++;
            beforeCnt = cheeseCount;
            melt();
        }

        System.out.println(resultTime);
        System.out.println(beforeCnt);

    }

    static public void melt() {
        isVisited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        //isVisited = new boolean[N][M];
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || N <= nx || M <= ny || isVisited[nx][ny]) continue;

                if (board[nx][ny] == 1) {
                    cheeseCount--;
                    board[nx][ny] = 0;
                } else if (board[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                }
                isVisited[nx][ny] = true;
            }
        }
    }


}