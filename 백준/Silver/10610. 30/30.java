import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String nums;
    static int[] numCnt;
    static int zeroCnt = 0;
    static int total = 0;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = br.readLine();

        numCnt = new int[10];

        for (int i = 0; i < nums.length(); i++) {
            int n = nums.charAt(i) - '0';
            if (n == 0) zeroCnt++;

            numCnt[n] += 1;
            total += n;
        }

        if (zeroCnt == 0 || total % 3 != 0) {
            System.out.println(-1);
            System.exit(0);
        }

        for (int i = 9; i >= 0; i--) {
            while (numCnt[i]>0){
                sb.append(i);
                numCnt[i]--;
            }
        }

        System.out.println(sb);


    }

}