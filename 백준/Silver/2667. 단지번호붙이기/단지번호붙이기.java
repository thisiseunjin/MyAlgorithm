import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] isVisited;
    static int[] count = new int[626];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        int num=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!isPossible(i,j)) continue;
                dfs(i,j,++num);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        sb.append(num+"\n");
        for(int i=1;i<num+1;i++){
            list.add(count[i]);
        }

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)+"\n");
        }

        System.out.println(sb);

    }

    public static void dfs(int x, int y, int num) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        isVisited[x][y] = true;
        count[num]++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isPossible(nextX, nextY)) continue;

            dfs(nextX, nextY, num);
        }
    }

    public static boolean isPossible(int x, int y) {
        if (x < 0 || y < 0 || x > N - 1 || y > N - 1) return false;
        if (isVisited[x][y]) return false;
        if (board[x][y] == 0) return false;

        return true;

    }


}