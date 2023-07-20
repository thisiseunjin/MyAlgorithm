import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = 0;

    static class Egg {
        int durability, weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Egg{" +
                    "durability=" + durability +
                    ", weight=" + weight +
                    '}';
        }
    }

    static Egg info[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        info = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            info[i] = new Egg(d, w);
        }

        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int idx, int cnt) {
        // 마지막 계란까지 다 들어봤으면 종료
        if(idx == N) {
            // 최댓값 갱신
            result = Math.max(result, cnt);
            return;
        }
        // 손으로 든 계란이 이미 깨졌거나 모든 계란이 이미 다 깨져 있다면
        if(info[idx].durability <= 0 || cnt == N-1) {
            // 다음 계란을 들어 봄
            dfs(idx + 1, cnt);
            return;
        }
        // 다른 계란들과 모두 부딪혀봄
        int nCnt = cnt;
        for(int i=0; i<N; i++) {
            // 손으로 들고 있는 계란과 부딪히려고 하는 계란이 같은 계란이라면 통과
            if(i == idx) continue;
            // 부딪혀 보려고 하는 계란이 이미 깨져있다면 통과
            if(info[i].durability <= 0) continue;
            // 계란끼리 부딪혀봄 (현재 손에 들고 있는 계란의 인덱스, 부딪혀보려는 타겟 계란 인덱스)
            hitEgg(idx, i);
            // 부딪혀 봤는데 손에 든 계란이 깨지면 cnt++
            if(info[idx].durability <= 0) {
                cnt++;
            }
            // 부딪혀 봤는데 타겟이 된 계란이 깨지면 cnt++
            if(info[i].durability <= 0) {
                cnt++;
            }
            // 재귀 호출 -> 다음 계란 들어 봄
            dfs(idx + 1, cnt);
            // for문의 다음 i를 위해 값을 원상복구 해 줌
            recoveryEgg(idx, i);
            cnt = nCnt;
        }
    }

    // 계란끼리 부딪혀보는 메소드
    static void hitEgg(int handEgg, int targetEgg) {
        info[targetEgg].durability -= info[handEgg].weight;
        info[handEgg].durability -= info[targetEgg].weight;
    }

    // 다시 원상복구 하는 메소드
    static void recoveryEgg(int handEgg, int targetEgg) {
        info[targetEgg].durability += info[handEgg].weight;
        info[handEgg].durability += info[targetEgg].weight;
    }
}