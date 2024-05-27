import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] info;
    static boolean[] isSelected;
    static int[] selected;
    static int result = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        info = new int[N][N];
        isSelected = new boolean[N];
        selected = new int[N / 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);
        System.out.println(result);


    }

    public static void comb(int start, int cnt) {
        if (cnt == N / 2) {

            //최솟값을 찾아준다.
            calc();
            return;
        }

        for (int i = start; i < N; i++) {
            if (isSelected[i]) continue;

            isSelected[i] = true;
            comb(i + 1, cnt + 1);
            isSelected[i] = false;
        }
    }

    public static void calc() {
        if (result == 0) return;

        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isSelected[i] && isSelected[j]) {
                    start += info[i][j];
                    start += info[j][i];
                    continue;
                }

                if (!isSelected[i] && !isSelected[j]) {
                    link += info[i][j];
                    link += info[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        result = Math.min(result, diff);
    }

}