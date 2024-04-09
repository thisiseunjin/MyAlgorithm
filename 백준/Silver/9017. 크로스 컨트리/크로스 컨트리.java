import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        //T번 반복해서 입력을 받는다.
        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());    //들어오는 선수의 수
            int[] ranking = new int[N];
            int[] fifthScore = new int[201];
            HashMap<Integer, Integer> count = new HashMap<>(); //지금 들어온 선수의 수를 저장할 map

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int team = Integer.parseInt(st.nextToken());
                count.put(team, count.getOrDefault(team, 0) + 1);
                ranking[i] = team;
            }

            HashMap<Integer, Integer> totalScore = new HashMap<>(); //팀의 점수 합을 저장할 map
            HashMap<Integer, Integer> tmp = new HashMap<>();

            int s = 1;
            //각 ranking합 저장
            for (int team : ranking) {
                if (count.get(team) < 6) continue; //6명이 안 들어오면 더해주지 않을 것임.

                //지금까지 몇번째인지 계산해주는 tmp에 더해준다
                tmp.put(team, tmp.getOrDefault(team, 0) + 1);
                if (tmp.get(team) < 5) {
                    //4번째 안이라면? 더해준다.
                    totalScore.put(team, totalScore.getOrDefault(team, 0) + s);
                }

                if (tmp.get(team) == 5) {
                    fifthScore[team] = s;
                }

                s++;
            }

            List<Integer> keys = new ArrayList<>(totalScore.keySet());
            keys.sort((x, y) -> {
                if (Objects.equals(totalScore.get(x), totalScore.get(y))) {
                    return fifthScore[x] - fifthScore[y];
                } else {
                    return totalScore.get(x) - totalScore.get(y);
                }
            });

            System.out.println(keys.get(0));

        }


    }


}