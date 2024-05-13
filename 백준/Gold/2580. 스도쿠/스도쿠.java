import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    static boolean isFind = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start(0, 0);

        System.out.println(sb);


    }

    static void start(int x, int y) {
        if (isFind) return;


        if (y == 9) {
            //다음 행 처음부터 시작 고
            start(x + 1, 0);
            return;
        }

        if (x == 9) {
            //종료 조건
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }

                sb.append("\n");
            }
            isFind = true;
            return;
        }


        if (map[x][y] != 0) {
            start(x, y + 1);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (!isPossible(x, y, i)) continue;
            map[x][y] = i;
            start(x, y + 1);
        }

        //방문 체크 해제
        map[x][y] = 0;


    }

    static boolean isPossible(int x, int y, int num) {

        //같은 행과 열에 겹치는 친구가 있다?
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num) return false;
            if (map[i][y] == num) return false;
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }

        return true;
    }
}