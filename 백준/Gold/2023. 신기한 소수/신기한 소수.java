import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;   //소수의 자릿수
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 2; i < 10; i++) {
            permutation(String.valueOf(i));
        }

        System.out.println(result);
    }

    public static void permutation(String num) {
        if (!isDecimal(num)) return;

        if (num.length() == N) {
            //종료 조건
            if (isDecimal(num)) result.append(num + "\n");
        }

        for (int i = 1; i < 10; i++) {
            permutation(num + i);
        }
    }

    public static boolean isDecimal(String str) {
        int number = Integer.parseInt(str);

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}