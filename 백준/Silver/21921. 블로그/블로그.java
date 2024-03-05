import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;   //블로그 1일차부터 N일차 까지
    static int X;   //X일동안 가장 많이 들어온 방문자 수 출력
    static int resultVisited;
    static int countVisited; //가장 많이 몇명??
    static int countWeek;
    static int[] toDayView;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        toDayView = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            toDayView[i] = Integer.parseInt(st.nextToken());
            if(toDayView[i]>0) isPossible = true;
        }

        if(!isPossible){
            System.out.println("SAD");
            return;
        }

        //걍 투포인터 시작임
        //초기화 진행
        for (int i = 0; i < X; i++) {
            countVisited += toDayView[i];
        }
        resultVisited = countVisited;
        countWeek = 1;

        int start = 0;
        int end = X;
        for (int i = end; i < N; i++) {
            //1. 이전 start값을 뺀다
            countVisited-= toDayView[start++];
            //2. 지금 end값 넣는다
            countVisited+=toDayView[i];


            //만약 지금 countVisited가 이전것 보다 크면?
            if(resultVisited<countVisited){
                resultVisited = countVisited;
                countWeek=1;
            }else if(resultVisited==countVisited){
                countWeek+=1;
            }

        }

        System.out.println(resultVisited);
        System.out.println(countWeek);


    }


    static class Point implements Comparable<Point>{
        int date;
        int count;

        public  Point(int date, int count) {
            this.date = date;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return o.count-this.count;
        }
    }
}