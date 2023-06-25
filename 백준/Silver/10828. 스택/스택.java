import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                push(num);
            }else if(op.equals("pop")) pop();
            else if (op.equals("size")) {
                size();
            }else if(op.equals("empty")){
                empty();
            }else top();
        }
        System.out.println(sb);

    }

    static void push(int num){
        stack.push(num);
    }

    static void pop(){
//        int num = stack.pop()==null?-1:stack.pop();
//        sb.append(num+"\n");
        if(stack.isEmpty()){
            sb.append("-1\n");
        }else {
            sb.append(stack.pop()+"\n");
        }
    }

    static void size(){
        sb.append(stack.size()+"\n");
    }

    static void empty(){
        if(stack.isEmpty()){
            sb.append("1"+"\n");
        }else {
            sb.append("0\n");
        }
    }

    static void top(){
        if(stack.isEmpty()){
            sb.append("-1\n");
        }else {
            sb.append(stack.peek()+"\n");
        }
    }
}