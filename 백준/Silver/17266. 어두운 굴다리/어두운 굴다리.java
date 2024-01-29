import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M; //굴다리를 설치할 개수
    static int[] x; //가로등이 있는 곳의 위치
    //가로등의 높이만큼 밝힐 수 있으며, 최소한의 높이로 지을 것이다.
    static int N;   //굴다리의 길이
    static int result  = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        x = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int input = Integer.parseInt(st.nextToken());
            x[i] = input;
        }

        //이분탐색 시작
        int right = N;
        int left = 0;
        int mid;

        while(left<=right){
            mid = (right+left)/2;
            //만약에 불가능 하면? 높이를 더 높여야 한다.
            if(!isPossible(mid)){
                left=mid+1;
            }else{
                //가능하면? 돈 더 줄여볼만함
                right = mid-1;
                result = mid;
            }
        }

        System.out.println(result);

    }

    public static boolean isPossible(int h){
        //현재 높이로 가능한지 먼저 확인해보는 함수
        //처음 위치검사하려면

        if(M==1){
            if(x[0]>h) return false;
            if(x[0]+h<N) return false;

            return true;
        }

        for (int i = 0; i < M; i++) {
            if(i==0){
                //첫 시작인 경우 자신이 h보다 크면 안된다
                if(x[i]>h) return false;
            }else{
                //나머지의 경우 높이*2보다 넓게 떨어지명 망함.
                int now = x[i];
                int before = x[i-1];

                if(now-before>h*2) return false;
                if(i==M-1) {
                    //내가 제일 마지막인 경우는 내 거리 +h가 가장 N보다 작으면 망함
                    if (x[i] + h < N) return false;
                }

            }
        }
//        System.out.println(h+"일때 가능함.");
        return true;
    }
}