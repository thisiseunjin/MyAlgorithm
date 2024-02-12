import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;   //만들어야할 랜선의 개수
    static int K; //가지고 있는 랜선의 개수
    /*
        - N개 모두 동일한 길이의 랜선으로 만들고싶다.
        - N개모다 많이 만드는 것도 가능하다.
        - 만들 수 있는 최대 랜선의 길이를 구하시오.
     */
    static int[] lines;
    static int result=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long right =0 ;

        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, lines[i]);
        }

        long left = 1;
        long mid;

        while(left<=right){
            mid = (int)((left+right)/2);

            //만들수 있는 개수가 더 크면? 길이를 늘려본다.
            if(counting(mid)>=N){
                left = mid+1;
                result = (int) Math.max(result,mid);
            }else{
                //더 작으면? 길이를 줄여본다
                right = mid-1;
            }
        }

        System.out.println(result);

    }

    public static int counting(long num){
        //num길이를 가진 막대기를 얼마나 만들 수 있을까?
        int cnt=0;
        for (int i = 0; i < K; i++) {
            cnt+= (int)(lines[i]/num);
        }

        return cnt;
    }


}