import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 나이트가 모든 칸을 1번씩만 방문한다.
    // 마지막으로 방분하는 칸에서 시작점으로 돌아올 수 있는 경로.
    static Point start;
    static Point end;
    static boolean[][] isVisited = new boolean[36][36];
    static int count=0;   //방문한 칸의 수
    static ArrayList<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 : 나이트가 방문한 순서대로 입력이 주어진다.
        for (int i = 0; i < 36; i++) {
            String input = br.readLine();
            int x = input.charAt(1)-'1';
            int y = input.charAt(0)-'A';
            list.add(new Point(x,y));
        }


        //조건1 : 정상적으로 이동 했는가? 8방으로 움직일 수 있다. distance가 1이다.
        //조건2 : 나이트가 모든 칸에 방문 했는가?
        //조건3 : 마지막 칸에서 출발점으로 돌아올 수 있는가?
        for (int i = 0; i < 36; i++) {
            Point p = list.get(i);

            //방문한 적이 있는지 확인
            if(isVisited[p.x][p.y]){
//                System.out.println("Invalid : 중복된 값 존재");
                System.out.println("Invalid");
                return;
            }

            //정상적으로 이동했는지 확인
            if(i>0){
                if (!canMove(list.get(i-1), list.get(i))){
//                    System.out.println("Invalid : 정상적으로 작동하지 않음.");
                    System.out.println("Invalid");
                    return;
                }
            }

            //방문 체크
            isVisited[p.x][p.y] = true;
            count+=1;
        }

        //1. 모두 방문 했는지 확인
        if(count<36){
//            System.out.println("Invalid : 모두 방문 하지 않음");
            System.out.println("Invalid");
            return;
        }

        //2. 마지막 점에서 첫 점으로 도달 가능한지 확인
        if(!canMove(list.get(0), list.get(35))){
//            System.out.println("Invalid : 첫점 에러");
            System.out.println("Invalid");

            return;
        }

        System.out.println("Valid");



    }

    public static boolean canMove(Point from, Point to){
        int dist = (int) Math.sqrt(Math.pow(from.x-to.x,2)+Math.pow(from.y-to.y,2));
//        System.out.println(from+ " "+to);
//        System.out.println(dist);
        return dist<=2;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "( "+this.x+", "+this.y+" )";
        }
    }
}