import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //사람들은 자기 보다 큰 사람이 왼쪽에 몇 명 있는지 기억한다
    //사람들의 키는 1부터 N까지 모두 다르다

    // 2(1), 1(2), 1(3), 0(4)
    //idx가 키의 번호라고 생각하면 된다.

    //1이 왼쪽에 2명이 있다? -> 1은 세번째에 서 있다.
    //2의 왼쪽에 1명이 있다? -> 2는 두번째에 있다.
    //3의 왼쪽에 1명이 있다? -> 3은 4의 뒤에 있다.
    //4가 맨 처음에 있다.

    static int N;
    static int[] info;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        info = new int[N + 1];
        result = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            int n = info[i];    //내 앞에 큰 사람이 와야하는 수
            int idx = 0;
            while (true) {

                if (n == 0 && result[idx] == 0) {
                    result[idx] = i;
                    break;
                }

                if (result[idx] == 0) {
                    //아직 지나가지 않은 경우임.
                    n--;
                    idx++;
                    continue;
                }

                if (result[idx] > i) {
                    // 내 키보다 크다?
                    n--;
                    idx++;
                    continue;
                }

                if (result[idx] < i) {
                    idx++;
                }
            }
        }

        for (int n : result) {
            sb.append(n+" ");
        }

        System.out.println(sb);


    }

}