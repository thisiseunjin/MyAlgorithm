import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int totalCnt = 0; //나무의 전체 개수
    static Map<String, Integer> map = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (true) {
            name = br.readLine();
            if (name == null || name.equals("")) break;
            totalCnt++;
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        for (String key : keyList) {
            sb.append(key).append(" ");
            double width = (double) map.get(key) * 100 / (double) totalCnt;
            sb.append(String.format("%.4f", width)).append("\n");
        }

        System.out.println(sb);


    }
}