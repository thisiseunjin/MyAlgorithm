import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        boolean flag = true;
        while (true){
            String input = br.readLine();
            if(input.startsWith("0")) break;
            st = new StringTokenizer(input);

            int arr[] = new int[3];

            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
//                if(arr[i]==0) flag = false;
            }


            Arrays.sort(arr);

            if(arr[0]+arr[1]<arr[2]) {
                sb.append("wrong\n");
                continue;
            }

            arr[0]*=arr[0];
            arr[1]*=arr[1];
            arr[2]*=arr[2];

            if(arr[0]+arr[1]==arr[2]){
                sb.append("right\n");
            }else{
                sb.append("wrong\n");
            }


        }

        System.out.println(sb);
    }
}