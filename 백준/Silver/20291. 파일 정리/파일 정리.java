import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Map<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            String name = st.nextToken();
            String type = st.nextToken();


            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }


    }
}