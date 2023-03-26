import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int result = 0;
		if(N<100)
			result = N;
		else if(N==1000) result = 144;
		else {
			//세자리 수일경우
			if(N<1000) {
				result = 99;
				for(int i=N;i>99;i--)
					if(isHan(i)) result+=1;
			}
			
			
			
		}
		
		System.out.println(result);
	}
	
	static boolean isHan(int num) {
		int n1 = num%10;
		int n2 = (num/10)%10;
		int n3 = (num/100)%10;
		
		int diff1 = n1-n2;
		int diff2 = n2-n3;
		
		if(diff1 == diff2) return true;
		else return false;
	}
}