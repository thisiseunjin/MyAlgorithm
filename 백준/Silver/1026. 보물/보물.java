import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> A;
    static ArrayList<Integer> B;
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new ArrayList<>();
        B = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        //가장 작은 값을 구한다? A의 최대 * B의 최대이다.

        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(B);

        for (int i = 0; i < N; i++) {
            result+=(A.get(i) * B.get(i));
        }


        System.out.println(result);

    }

}