import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int result;
    static int[] nums;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N+1]; //1부터 N까지의 숫자가 들어올 것이기 때문
        counts = new int[200001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int endIdx =1;
        counts[nums[startIdx]]+=1;
        int length = 1;
        while (endIdx<N){
            //끝값을 넣기 전에? K보다 큰지 작은지 확인
//            System.out.println(Arrays.toString(nums));
//            System.out.println(Arrays.toString(counts));
            if(counts[nums[endIdx]]+1>K){
                //못간다. start++해주기
                counts[nums[startIdx++]]-=1;
//                startIdx++;
                length-=1;
                result = Math.max(length, result);


            }else{
                //갈 수 있음? 간다.
                //방문 체크
                counts[nums[endIdx++]]+=1;
                length+=1;
                result = Math.max(length, result);
            }

            if(endIdx==N+1){
                result = Math.max(length, result);
            }
//            System.out.println("start = "+startIdx+", end = "+endIdx+", length = "+length);
        }

        System.out.println(result);
    }
}