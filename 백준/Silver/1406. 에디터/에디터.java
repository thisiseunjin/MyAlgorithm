import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //    static int cursor = 0;
    static LinkedList<Character> list = new LinkedList<>();
    static ListIterator<Character> cursor;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        cursor = list.listIterator();

        while (cursor.hasNext()) {
            cursor.next();
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char op = str.charAt(0);

            if (op == 'L' && cursor.hasPrevious()) {
                cursor.previous();
                continue;
            }

            if (op == 'D' && cursor.hasNext()) {
                cursor.next();
                continue;
            }

            if (op == 'B' && cursor.hasPrevious()) {
                cursor.previous();
                cursor.remove();
                continue;
            }

            if (op == 'P') {
                char ch = str.charAt(2);
                cursor.add(ch);
            }


        }

        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }

        System.out.println(sb);
    }
}