import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int K = 0;
    static StringBuilder sb = new StringBuilder();
    static int length = 3;  //S(0) : moo 로 length가 3이기 때문 S(1)은 중간이 3+1로 4가 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (length <= N) {
            K++;
            length = length + (K + 3) + length;
        }

        find(K);
        System.out.println(sb);

    }

    public static void find(int k) {
        if (3 >= N) {
            //S(0)인 상황
            if (N == 1) sb.append("m");
            else sb.append("o");
            return;
        }

        //내 앞은 다 빼나다.
        int tmp = (length - (k + 3)) / 2;
        if (N <= tmp) {
            //크면은 내 앞 길이와 동일해 진다.
            length = tmp;
            find(k - 1);
        } else if (N - tmp <= k + 3 && N - tmp <= (k + 3) + tmp) {
            N -= tmp;
            if (N == 1) sb.append("m");
            else sb.append("o");
        } else {
            N -= tmp;
            N -= (k + 3);
            length = tmp;
            find(k - 1);
        }
    }

}