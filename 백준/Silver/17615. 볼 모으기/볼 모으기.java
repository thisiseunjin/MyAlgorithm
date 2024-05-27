

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] info;
    static String input;
    static int redCount = 0;
    static int blueCount = 0;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        info = new char[N];
        for (int i = 0; i < N; i++) {
            info[i] = input.charAt(i);
            if (info[i] == 'B') blueCount++;
            else redCount++;
        }

        result = Math.min(redCount, blueCount);

        if (redCount == 0 || blueCount == 0) {
            System.out.println(0);
            System.exit(0);
        }

        //R을 맨 왼쪽으로
        int count = 0;

        count = 0;
        for (int i = 0; i < N; i++) {
            if (info[i] == 'R') {
                count++;
            } else break;
        }

        result = Math.min(result, redCount - count);

        count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (info[i] == 'R') {
                count++;
            } else break;
        }

        result = Math.min(result, redCount - count);

        count = 0;
        for (int i = 0; i < N; i++) {
            if (info[i] == 'B') {
                count++;
            } else break;
        }

        result = Math.min(result, blueCount - count);

        count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (info[i] == 'B') {
                count++;
            } else break;
        }

        result = Math.min(result, blueCount - count);

        System.out.println(result);
    }


}
