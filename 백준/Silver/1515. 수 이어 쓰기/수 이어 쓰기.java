import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //남은 수를 이어 붙인 수가 주어질 때, N의 최솟값을 구하는 프로그램?
    static int N = 0;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();


        int idx = 0; //현재 내가 확인하고 있는 위치
        while (idx < input.length()) {
            N++;
            String str = Integer.toString(N);

            //N이 2자리 수 이상이 될수도 있음.
            for (int i = 0; i < str.length(); i++) {
                if (input.charAt(idx) != str.charAt(i)) continue;
                idx++;
                if (idx >= input.length()) break;
            }
        }

        System.out.println(N);

    }
}