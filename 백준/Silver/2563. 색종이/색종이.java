import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static boolean[][] arr = new boolean[100][100];
	static int x, y;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if (!arr[i][j]) {
						result++;
						arr[i][j] = true;
					}
				}
			}
		}

		System.out.println(result);

	}

}
