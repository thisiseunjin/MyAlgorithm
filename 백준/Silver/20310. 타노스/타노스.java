import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

public class Main {
    static String input;
    static int zeroCount;
    static int oneCount;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char num = input.charAt(i);
            if (num == '0') zeroCount++;
            else oneCount++;
        }

        zeroCount /= 2;
        oneCount /= 2;

//        sb.append("0".repeat(zeroCount));
//        sb.append("1".repeat(oneCount));

        for (int i = 0; i < zeroCount; i++) {
            sb.append("0");
        }
        for (int i = 0; i < oneCount; i++) {
            sb.append("1");
        }

        System.out.println(sb);


    }


}