import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N; //끊어진 기타 줄의 수
    static int M;   //브랜드의 수
    static PriorityQueue<Integer> packsQ = new PriorityQueue<>();
    static PriorityQueue<Integer> oneQ = new PriorityQueue<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmps = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());

            save(tmps, tmp);
        }

        while (true){
            if(N<6){
                //6보다 작다면? 한번만 보고 끝!
                int price = Math.min(packsQ.peek(), oneQ.peek()*N);
                result+=price;
//                System.out.println("남은 개수"+N+", 구매할 가격"+price);
                break;
            }

            int cnt = N/6;  //나누고 난 후의 분모
            int price = cnt*packsQ.peek();
            result+=price;
//            System.out.println("남은 개수"+N+", 구매할 가격"+price);
            N-=(cnt*6);



        }

        System.out.println(result);

    }

    public static void save(int pack, int one){
        packsQ.add(Math.min(pack, one*6));
        oneQ.add(one);
    }


}