import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //비밀번호 조건
    // 1. 모음(a,e,i,o,u)는 반드시 포함 되어야 한다.
    // 2. 모음이 3개 혹은 자음이 3개 연속이면 안된다.
    // 3. 같은 글자가 연속으로 2번 나오면 안되나, ee와 oo는 허용한다.

    static boolean isContain; // 1. 포함 되었는지 아닌지 판단하는 flag
    static int vowelsCnt;   //연속된 모음의 개수
    static int consonantsCnt;  //연속된 자음의 개수
    static char preChar;    //이전의 글자
    static boolean isAccepted;
    static int duplicateCnt;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (true) {

            input = br.readLine();
            if (input.equals("end")) break;

            init();

            preChar = input.charAt(0);
            if (isVowels(preChar)) {
                //모음이다?
                isContain = true;
                vowelsCnt++;
            }else{
                consonantsCnt++;
            }

            for (int i = 1; i < input.length(); i++) {
                char c = input.charAt(i);

                //이 전이랑 동일한가?
                if (preChar == c && c != 'e' && c != 'o') {
                    //동일하다! 때려쳐!
                    isAccepted = false;
                    break;
                }

                if (isVowels(c)) {
                    //모음이다.
                    isContain = true;
                    vowelsCnt++;
                    consonantsCnt = 0;
                    if (vowelsCnt == 3) {
                        isAccepted = false;
                        break;
                    }

                } else {
                    //자음이다.
                    consonantsCnt++;
                    vowelsCnt = 0;
                    if (consonantsCnt == 3) {
                        isAccepted = false;
                        break;
                    }
                }
                preChar = c;
            }

            if (!isContain) isAccepted = false;

            sb.append("<").append(input).append(">");
            if (isAccepted) {
                sb.append(" is acceptable.\n");
            } else {
                sb.append(" is not acceptable.\n");
            }

        }
        System.out.println(sb);
    }


    public static boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void init() {
        consonantsCnt = 0;
        vowelsCnt = 0;
        isContain = false;
        isAccepted = true;
    }

}