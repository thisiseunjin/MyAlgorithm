import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static String input;
    static int[] num;
    static char[] op;
    static boolean isSelected[];
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();
        num = new int[(N / 2) + 1];
        op = new char[N / 2];
        isSelected = new boolean[N / 2];

        //숫자는 숫자 배열에 문자는 문자 배열에 저장해준다
        int numIdx = 0;
        int opIdx = 0;

        for (int i = 0; i < N; i++) {
            char in = input.charAt(i);
            if (i % 2 == 0) {
                num[numIdx++] = in - '0';
            } else {
                op[opIdx++] = in;
            }
        }
        if(N==1){
            System.out.println(num[0]);
            return;
        }

        if(N==3){
            System.out.println(calc(num[0],num[1],op[0]));
            return;
        }

        comb(0);
        System.out.println(result);

    }

    static public void comb(int cnt) {
        int calc_result = 0;
        if (cnt == N / 2) {
            //계산해본다
            //int tmp=0;
            int[] num_calc = num.clone();
//            System.out.println("우선순위 것들");
//            System.out.println(Arrays.toString(num));
//            System.out.println(Arrays.toString(op));
//            System.out.println(Arrays.toString(isSelected));
            for (int i = 0; i < N / 2; i++) {
                if (isSelected[i]) {
                    //우선 순위가 있다.
                    num_calc[i] = calc(num[i], num[i + 1], op[i]);
                    num_calc[i + 1] = num_calc[i];
                    //System.out.println(Arrays.toString(num_calc));
                }

            }


//            System.out.println("우선순위 아닌ㄴ 것들");
//            System.out.println(Arrays.toString(num_calc));
//            System.out.println(Arrays.toString(op));
//            System.out.println(Arrays.toString(isSelected));
            for (int i = 0; i < N / 2; i++) {
                if (!isSelected[i]) {
                    num_calc[i] = calc(num_calc[i], num_calc[i + 1], op[i]);
                    calc_result = num_calc[i];
                    for (int j = i+1; j < (N / 2)+1; j++) {

                        num_calc[j] = num_calc[i];
                       // System.out.println(Arrays.toString(num_calc)+ " --- "+j);
                       if(j<N/2){
                           if(!isSelected[j])break;
                       }
                    }
                    //System.out.println(Arrays.toString(num_calc));
                }

            }


            //System.out.println(calc_result);

            result = Math.max(result, calc_result);
            return;

        }
        if (cnt == 0) {
            isSelected[cnt] = true;
            comb(cnt + 1);
            isSelected[cnt] = false;
            comb(cnt + 1);
        } else {
            if (!isSelected[cnt - 1]) {
                isSelected[cnt] = true;
                comb(cnt + 1);
            }
            isSelected[cnt] = false;
            comb(cnt + 1);
        }

    }

    static public int calc(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}