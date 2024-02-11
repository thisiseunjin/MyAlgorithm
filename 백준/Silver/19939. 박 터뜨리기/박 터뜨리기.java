import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;   //공의 개수
    static int K;   //바구니의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int tmp = (K*(K+1))/2;
        if(tmp>N){
            System.out.println(-1);
        }
        else if(tmp==N){
            System.out.println(K-1);
        }else {
            N-=tmp;
            if(N%K==0) System.out.println(K-1);
            else{
                System.out.println(K);
            }
        }


    }

}