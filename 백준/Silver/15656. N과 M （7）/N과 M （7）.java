import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] inputs;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inputs = new int[N];
        numbers = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);
        comb(0);

        System.out.println(sb);

    }
    public static void comb(int cnt){
        if(cnt==M){
            //종료조건
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            numbers[cnt] = inputs[i];
            comb(cnt+1);
        }
    }

}