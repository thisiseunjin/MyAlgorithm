import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map = new int[20][20];
    static int[] dx = {0,1,1,-1};
    static int[] dy = {1,0,1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //맵 초기화 완료
        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (map[i][j] == 0) continue;
                if (!find(i, j)) continue;

                System.out.println(map[i][j]);
                System.out.println(i + " " + j);
                System.exit(0);
            }
        }


        System.out.println(0);

    }

    static boolean find(int x, int y) {
        int color = map[x][y];

        for (int i = 0; i < 4; i++) {
            int count = 1;
            for (int j = 1; j < 7; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (!inRange(nx, ny) || map[nx][ny] != color) break;
                count++;
            }
            //정답일 조건

            int preX = x - dx[i];
            int preY = y - dy[i];

            if (count != 5) continue;
            if (inRange(preX, preY) && map[preX][preY] == color) continue;


            return true;

        }

        return false;
    }

    static boolean inRange(int x, int y) {
        return x <= 19 && y <= 19 && x >= 1 && y >= 1;
    }
}