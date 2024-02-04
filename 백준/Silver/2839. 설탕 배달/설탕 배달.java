import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //상근이는 5kg, 3kg가져갈 수 있음.
        while (N>=0){
            if(N%5==0){
                result+=(N/5);
                System.out.println(result);
                return;
            }

            N-=3;
            result++;
        }

        System.out.println(-1);
    }
}