import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] board = new boolean[5][5];
    static HashMap<Integer, Point> map = new HashMap<>();
    static int result=0;
//    static int bingoCnt =0; //빙고 3개이면 빙고임~~~

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //빙고판 저장 완료
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new Point(i,j));
            }
        }

        //이제 빙고판 부르고 없앨거임
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                result+=1;
                //말한 숫자의 위치를 표시해준다.
                Point p = map.get(num);
                board[p.x][p.y] = true;

                //그리고 빙고 확인하기
                if(isBingo()){
                    System.out.println(result);
                    return;
                }

            }
        }

        System.out.println(25);

    }

    public static boolean isBingo(){
        int bingoCnt =0;
        //가로 세로 대각선을 확인해서 빙고가 있는지 확인 후 빙고가 3개이면 찐빙고임

        //가로 세로 먼저 확인할거임
        for (int i = 0; i < 5; i++) {
            int cnt1 =0;
            int cnt2=0;
            for (int j = 0; j < 5; j++) {
                if(board[i][j]) ++cnt1;
                if(board[j][i]) ++cnt2;
            }
            if(cnt1==5) bingoCnt+=1;
            if(cnt2==5) bingoCnt+=1;

            //가로 세로에 대한 검증을 완료하였음.
        }

        //대각선 확인
        /*
                 0   1   2   3   4
              0
              1
              2
              3
              4

            대각선의 위치는 (4,0), (3,1), (2,2), (1,3), (0,4)
            다른 대각선은 ? (0,0), (1,1), (2,2), (3,3), (4,4)

            그롬 이제 for문을 돌려볼까??
         */

        int cnt1=0;
        int cnt2=0;
        for (int i = 0; i < 5; i++) {
            if(board[4-i][i]) ++cnt1;
            if(board[i][i]) ++cnt2;
        }

        if(cnt1==5) bingoCnt+=1;
        if(cnt2==5) bingoCnt+=1;

        return bingoCnt>2;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}