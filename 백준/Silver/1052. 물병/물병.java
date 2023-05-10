import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while(Integer.bitCount(N)>K){
            //1. 최소 원소를 찾아서 더해준다.
            result += N&(-N);
            N +=N&(-N);
        }

        System.out.println(result);
    }
}