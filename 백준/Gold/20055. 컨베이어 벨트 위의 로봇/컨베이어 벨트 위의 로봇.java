import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int SIZE;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        SIZE = 2 * N;

        belt = new int[SIZE];
        robot = new boolean[SIZE];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < SIZE; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        while (true) {
            result++;
            moveBelt();
            if (isDone()) break;
        }

        System.out.println(result);


    }

    public static void moveBelt() {

        //벨트 회전
        int endBelt = belt[SIZE - 1];
        for (int i = SIZE - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
            robot[i] = robot[i - 1];
        }
        belt[0] = endBelt;
        robot[0] = false;
        robot[N-1] = false;

       for(int i=N-1;i>0;i--){
           if(!robot[i-1]) continue;

           if(belt[i]==0) continue;

           if(robot[i]) continue;

           robot[i] = true;
           robot[i-1]=false;
           belt[i]-=1;
       }

        //로봇을 올리는 작업
        if (belt[0] > 0) {
            robot[0] = true;
            belt[0] -= 1;
        }


    }

    public static boolean isDone() {
        int count = 0;

        for (int i = 0; i < SIZE; i++) {
            if (belt[i] == 0) count++;
        }

        if (count >= K) return true;
        return false;

    }


}