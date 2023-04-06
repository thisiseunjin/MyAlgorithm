import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String,String> map = new HashMap<>();
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <=N ; i++) {
            String input = br.readLine();
            map.put(Integer.toString(i),input);
            map.put(input,Integer.toString(i));
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            System.out.println(map.get(input));
        }
    }
}