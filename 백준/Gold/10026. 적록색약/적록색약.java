import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] board;
    static char curColor_common;
    static char curColor_uncommon;
    static int result_RGB = 0, result_RB = 0;
    static boolean isVisited_RGB[][], isVisited_RB[][];
    static int count_RGB = 0, count_RB = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        //적록 색맹은 R과 G를 구분할 수 없다.
        isVisited_RB = new boolean[N][N];
        isVisited_RGB = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count_RB = 0;
                count_RGB = 0;
                curColor_common = curColor_uncommon = board[i][j];

                if (isPossible(false, i, j)) dfs(false, i, j);
                if (isPossible(true, i, j)) dfs(true, i, j);
                if (count_RB > 0) result_RB++;
                if (count_RGB > 0) result_RGB++;


            }
        }

        System.out.println(result_RGB + " " + result_RB);
    }

    public static void dfs(boolean isRB, int x, int y) {
        //방문체크

        if (isRB) {
            isVisited_RB[x][y] = true;
            count_RB++;
        } else {
            isVisited_RGB[x][y] = true;
            count_RGB++;
        }

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isPossible(isRB, nx, ny)) {
                dfs(isRB, nx, ny);
            }

        }

    }

    public static boolean isPossible(boolean isRB, int x, int y) {
        // 공통
        if (x >= N || y >= N || x < 0 || y < 0) return false;
        if (isRB) {
            //적록색맹인 경우이다.
            if (isVisited_RB[x][y]) return false;
            if (curColor_uncommon == 'R' || curColor_common == 'G') {
                if (board[x][y] == 'B') {
                   // System.out.println("색체크!");
                    return false;
                } else {
                    return true;
                }
            } else {
                if (board[x][y] != curColor_uncommon) return false;
                else return true;
            }
        } else {
            //적록색맹이 아닌 경우
            if (isVisited_RGB[x][y]) return false;
            if (board[x][y] != curColor_common) return false;

        }
        return true;
    }


}