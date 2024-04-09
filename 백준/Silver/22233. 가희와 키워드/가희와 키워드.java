import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;   //가희가 메모장에 적은 키워드의 개수
    static int M;   //가희가 블로그에 쓴 글의 개수 M
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            set.add(input);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ", ");
            while (st.hasMoreTokens()) {
                String input = st.nextToken();
                set.remove(input);
            }
            System.out.println(set.size());
        }
    }

}