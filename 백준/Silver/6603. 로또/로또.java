import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int input;
	static int N;
	static int nums[];
	static int flag = 0;
	static int maked[] = new int[6];
	//static boolean isVisited[];
	static StringBuilder sb = new StringBuilder();
	// static int cnt=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input = null;
		while (true) {
			input = br.readLine();
			if (input.equals("0"))
				break;
			st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			//System.out.println("반틈은?" + N / 2);
			nums = new int[N];
			//isVisited = new boolean[N];

			for (int i = 0; i < N; i++)
				nums[i] = Integer.parseInt(st.nextToken());

			comb(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void comb(int cnt, int start) {
		 if(cnt==6) {
			 for(int i=0;i<6;i++) {
				 sb.append(maked[i]+" ");
			 }
			 sb.append("\n");
			 return;
		 }
		 
		 for(int i=start;i<N;i++) {
			 maked[cnt]=nums[i];
			 comb(cnt+1, i+1);
		 }
	}
}
