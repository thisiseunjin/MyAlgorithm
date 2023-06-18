import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = (int)1e9;
    static int A;
    static int B;
//    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        calc(A,0);

        System.out.println(result==(int)1e9?-1:result+1);

    }

    public static void calc(long num, int cnt){
        if(num>=B){
            if(num==B){
                //정답이 될 가능성이 존재한다.
                result = Math.min(cnt, result);
            }
            return;
        }
        //할 수 있는 연산은?
        //2를 곱하기
        calc(num*2, cnt+1);
        calc(num*10 + 1, cnt+1);

    }
}