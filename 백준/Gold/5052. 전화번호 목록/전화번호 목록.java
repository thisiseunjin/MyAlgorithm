import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int N;
    static String numbers[];
    //    static ArrayList<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            numbers = new String[N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                str.replaceAll(" ", "");
                numbers[i] = str;
            }

            Arrays.sort(numbers);

            if (isContain()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }

    public static boolean isContain() {
        for (int i = 0; i < N - 1; i++) {
            if (numbers[i + 1].startsWith(numbers[i])) return false;
        }
        return true;
    }
}