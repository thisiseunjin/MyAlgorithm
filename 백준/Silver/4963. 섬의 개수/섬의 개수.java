import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] board;
    static boolean[][] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            int result =0 ;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            board = new int[h][w];
            isVisited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(isVisited[i][j]) continue;
                    if(board[i][j]==0) continue;
                    dfs(i,j);

                    result++;
                }
            }

            sb.append(result+"\n");

        }

        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        isVisited[x][y] = true;
        int[] dx = {-1, 1, 0, 0,-1,1,-1,1};
        int[] dy = {0, 0, -1, 1,-1,1,1,-1};
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isPossible(nextX, nextY)) continue;
            if (isVisited[nextX][nextY]) continue;
            if (board[nextX][nextY] ==0) continue;

            dfs(nextX, nextY);
        }
    }

    public static boolean isPossible(int x, int y) {
        if (x >= h || y >= w || x < 0 || y < 0) return false;

        return true;
    }
}