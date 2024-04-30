import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    /*
        규칙
        1. 두개의 단어가 같은 종류의 문자로 이루어져있다.
        2. 같은 문자는 같은 개수만큼 있다.

        추가 규칙
        1. 같은 구성을 같는 경우 ex) GOOD & GOD
        2. 문자 하나만 다른 경우 ex) GOD & DOG
     */
    static int N;
    static Word[] words;
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new Word[N];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            words[i] = new Word(str);
        }

        for (int i = 1; i < N; i++) {
            //첫 번째 단어와 비슷하면 장땡~!~!
            if (!isPossible(words[0], words[i])) continue;
//            System.out.println(words[i].w);
            result++;
        }


        System.out.println(result);

    }

    static boolean isPossible(Word w1, Word w2) {
        //길이가 2이상 차이 나면 나가리
//        if (Math.abs(w1.w.length() - w2.w.length()) > 2) return false;

        int cnt = 0;
        HashMap<Character, Integer> map1 = w1.map;
        HashMap<Character, Integer> map2 = w2.map;

        for (char key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                cnt += map1.get(key);
                continue;
            }

            int k1 = map1.get(key);
            int k2 = map2.get(key);
            cnt += Math.abs(k1 - k2);
            map2.remove(key);
        }

        //이제 남은 놈
        for (char key : map2.keySet()) {
            int c = map2.get(key);
            cnt += c;
        }


        // 문자 하나만 다른 경우 처리
        if (cnt <= 1) return true;

        // 같은 구성을 가진 경우 처리
        if (cnt == 2 && w1.w.length() == w2.w.length()) return true;

        return false;
    }

    static class Word {
        HashMap<Character, Integer> map = new HashMap<>();
        String w;

        public Word(String w) {
            this.w = w;

            for (int i = 0; i < w.length(); i++) {
                map.put(w.charAt(i), map.getOrDefault(w.charAt(i), 0) + 1);
            }

        }
    }

}