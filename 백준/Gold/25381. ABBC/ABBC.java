import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static String str;
    static int result = 0;
    //결국 B를 최대한 많이 지우는 것이 목표이다..!
    static Queue<Integer> aQueue = new ArrayDeque<>();
    static Queue<Integer> bQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'A') {
                aQueue.add(i);
            } else if (c == 'B') {
                bQueue.add(i);
            } else{
                if(bQueue.isEmpty()) continue;
                result++;
                bQueue.poll();
            }
        }

        while(aQueue.size()>0 && bQueue.size()>0){
            if(aQueue.peek()<bQueue.peek()){
                result++;
                bQueue.poll();
                aQueue.poll();
            }else{
                bQueue.poll();
            }
        }
        System.out.println(result);

    }

}