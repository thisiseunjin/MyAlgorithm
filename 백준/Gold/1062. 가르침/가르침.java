import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;   //단어의 개수
    static int K;   //배울 글자의 수
    static boolean[] isLearned = new boolean[26];   //배운 알파벳인가?
    static boolean[] alphabet = new boolean[26];    //단어에 있는 알파벳들
    static String[] strArr;
    static boolean[][] info;
    static int result = -(int) 1e9;
    static int learnCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        strArr = new String[N];
        info = new boolean[N][26];

        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();

            for (int j = 0; j < strArr[i].length(); j++) {
                if (!alphabet[strArr[i].charAt(j) - 'a']) {
                    learnCount++;
                    alphabet[strArr[i].charAt(j) - 'a'] = true;
                }
                info[i][strArr[i].charAt(j) - 'a'] = true;
            }
        }


        if (K < 5) {
            System.out.println(0);
            System.exit(0);
        }


        if (K >= 26) {
            System.out.println(N);
            System.exit(0);
        }

        //a,n,t,i,c는 무조건 배운다.
        char[] mustArr = {'a', 'n', 't', 'i', 'c'};

        for (char ch : mustArr) {
            isLearned[ch - 'a'] = true;
        }

        //내가 가르칠 수 있는 알바벳은?
        K -= 5;
        learnCount-=5;


        boolean isFind = false;
        for (int i = 0; i < 26; i++) {
            if (!isLearned[i] && alphabet[i]) {
                dfs(0, i);
                isFind = true;
                break;
            }
        }

        if (!isFind) {
            System.out.println(N);
            System.exit(0);
        }

        System.out.println(result == -(int) 1e9 ? 0 : result);

    }

    static void dfs(int cnt, int idx) {

        if (result == N) {
            return;
        }

        if (cnt == Math.min(K,learnCount)) {

            //다 가르쳤나? 종료 조건
            int count = 0;
            //몇개 읽을 수 있을까?
            for (int i = 0; i < N; i++) {
                boolean isPossible = true;
                for (int j = 0; j < 26; j++) {
                    if (info[i][j] && !isLearned[j]) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) count++;
            }
            result = Math.max(count, result);
            return;
        }

        //가르칠 수 있는것들은 가르쳐보면서 넘어감.
        for (int i = idx; i < 26; i++) {
            if (!alphabet[i]) continue;    //가르칠 필요가 없는 애들은 그냥 넘어간다.
            if (isLearned[i]) continue;    //이미 가르친 친구들도 그냥 넘어 간다.

            //가르쳐 본다
            isLearned[i] = true;  //방문 체크
            dfs(cnt + 1, i + 1);    //간다.
            isLearned[i] = false; //방문 체크 해제
        }
    }
}