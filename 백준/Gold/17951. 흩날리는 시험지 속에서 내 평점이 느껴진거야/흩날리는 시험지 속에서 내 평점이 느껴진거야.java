import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int totalSum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum+=arr[i];
        }

        int left = 0;
        //여기서 right값을 totalSum으로 해주어야한다는 사실을 깨닫지 못해... 참고를 하게 되었다.
        //즉, 최소합을 정해놓고 끼워 맞춰 넣을 수 있는지를 확인해보면 된다..!
        int right = totalSum;

        int result = -(int)1e9;

        while (left<=right){
            int mid = (left+right)/2;
            int count =0, sum=0;

            for(int i=0;i<N;i++){
                sum+=arr[i];
                if(sum<mid) continue;
                count++;
                sum =0;
            }

            if(count>=K) {
                left = mid+1;
                result = Math.max(result,mid);
            }
            else {
                right = mid-1;
            }
        }

        System.out.println(result);


    }
}