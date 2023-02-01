package D0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2798 {
	static int N;
	static int M;
	static int result[] = new int [3];
	static int sum=0;
	static int[] nums;
	static boolean[] isVisit;
	
	//static int tmp;
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isVisit = new boolean[N];
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		search(0);
		System.out.println(sum);
		
	}
	
	public static void search(int cnt) {
		//목적지인가?
		if(cnt==3) {
			int tmp = 0;
			for(int i : result) {
				tmp+=i;
			}
			if(tmp>M) return;
			if(tmp<=M) sum = Math.max(sum, tmp);
			
		}
		//목적지와 이어진 곳을 순회한다.
		else {
			for(int i=cnt;i<N;i++) {
				if(!isVisit[i]) {
					isVisit[i] = true;
					result[cnt]= nums[i];
					search(cnt+1);
					isVisit[i] = false;
				}
			}
		}
	}
}
