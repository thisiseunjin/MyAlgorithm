import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    //각각 사탕 개수에 가방을 나눈 몫의 합이 m 보다 크거나 같아야 된다.
    //가방에 최대한 담으면 1가방에 1번사탕/k + 2번 사탕/k + 3번 사탕/k  . . . N번 사탕/k  >= M 이면 답이 될 확률이 존재한다.
    static long M,T;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static long candy[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int test = 1; test < T+1; test++) {
            sb.append("#"+test+" ");
            st = new StringTokenizer(br.readLine());


            N = Integer.parseInt(st.nextToken());
            M = Long.parseLong(st.nextToken());

            candy = new long[N];

            long maxCount=0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                candy[i] = Long.parseLong(st.nextToken());
                maxCount = Math.max(maxCount,candy[i]);
            }

            long left = 1L;
            long right = maxCount;
            long res =0;

            while (left<=right){
                long mid = (left+right)/2;

                long sum =0L;
                for (int i = 0; i < N; i++) {
                    sum+=(candy[i]/mid);
                }

                if(sum<M){
                    right = mid-1;
                }else{
                    res = mid;
                    left = mid+1;
                }
            }
            sb.append(res+"\n");


        }

        System.out.print(sb);
    }
}