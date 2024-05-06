import java.io.*;

public class Main {
    static int N;
    static int result = 0;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N][N];

        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            result += 1;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isPossible(depth, i)) continue;
            isVisited[depth][i] = true;
            dfs(depth + 1);
            isVisited[depth][i] = false;
        }
    }

    public static boolean isPossible(int x, int y) {
        // 같은 열 체크
        for (int i = 0; i < x; i++) {
            if (isVisited[i][y]) return false;
        }
        // / 방향
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (isVisited[i][j]) return false;
        }
        // \방향
        for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
            if (isVisited[i][j]) return false;
        }
        return true;
    }
}