import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int num[];


    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("C:\\Users\\User\\IdeaProjects\\SW2022\\DAY2\\P2003\\input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num=new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }

        int High=0, Low=0, sum=num[0],result=0;


        while(true){


            if(sum<M){

                sum+=num[++High];

            } else if (sum>M) {
                sum-=num[Low++];

            } else  {
                result++;
                sum-=num[Low++];
            }

            if(High==N) break;

        }

        System.out.println(result);
    }
}
