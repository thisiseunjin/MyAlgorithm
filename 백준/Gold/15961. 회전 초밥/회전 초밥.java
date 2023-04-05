import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;   //초밥 벨트에 놓인 접시의 수
    static int d;   //초밥의 가짓수 d
    static int k;   //연속해서 먹는 접시의 수
    static int c;   //쿠폰번호
    static int[] sushi;
    static int[] count;

    static int resultMAX = 0; //결과값을 저장할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        count = new int[d + 1];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int diffCount = 0;
        //초기상태 설정
        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) diffCount++;
            count[sushi[i]]++;
        }

        resultMAX = diffCount;
        if (count[c] == 0) resultMAX += 1;
//        int start = 0,
        int end = k - 1;
        for (int i = 1; i < N; i++) {
            //이전에 있던 초기값을 빼준다.
            //빼고 나서 count값이 0이된다면 diffcount를 하나 감소시킨다.
            count[sushi[i - 1]]--;
            if (count[sushi[i - 1]] == 0) diffCount--;
            //end값을 늘려준다
            end++;
            //end값이 범위를 벗어날 경우 0으로 바꿔준다.
            if (end >= N) end = 0;
            //end값을 늘린 후 거기 있는 값을 count에 넣어준다
            if (count[sushi[end]] == 0) diffCount++;
            count[sushi[end]]++;
            //이때 count배열에 없는 값이면 diffcount를 늘려준다.
            //서비스 초밥도 생각해준다.
//            if (count[c] == 0) diffCount++;
//            resultMAX = Math.max(resultMAX, diffCount);
            //서비스 초밥이 경우가 다를 경우 diffcount가 늘어남
            if (count[c] == 0)
                resultMAX = Math.max(resultMAX, diffCount+1);
            else resultMAX = Math.max(resultMAX, diffCount);
        }

        System.out.println(resultMAX);
    }
}