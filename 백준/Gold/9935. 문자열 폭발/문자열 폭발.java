import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static String input;
    static String bomb;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        bomb = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);

            if (stack.size() < bomb.length()) continue;

            boolean isSame = true;  //폭발 문자가 있는지 확인하는 로직
            for (int j = 0; j < bomb.length(); j++) {
                char target = stack.get(stack.size() - bomb.length() + j);
                if (target == bomb.charAt(j)) continue;
                isSame = false;
                break;
            }


            if (!isSame) continue;

            for (int j = 0; j < bomb.length(); j++) {
                stack.pop();
            }
        }

        for (char ch : stack) {
            sb.append(ch);
        }

        System.out.println(sb.length()==0? "FRULA" : sb);
    }

}