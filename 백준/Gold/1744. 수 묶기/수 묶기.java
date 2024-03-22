import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> plusList = new ArrayList<>();
    static ArrayList<Integer> minusList = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num>0){
                plusList.add(num);
            }else{
                minusList.add(num);
            }
        }

        Collections.sort(plusList, Collections.reverseOrder());
        Collections.sort(minusList);

        //두 수를 곱했을때 최대가 되려면? 큰수 * 큰수가 가장 큰 수가 된다!!히히
        for (int i = 0; i < plusList.size(); i++) {
            if(i+1> plusList.size()-1){
                result+=plusList.get(i);
                continue;
            }

            int sum = plusList.get(i)+plusList.get(i+1);
            int mul = plusList.get(i)* plusList.get(i+1);

           if(mul>sum){
               result+=mul;
               i++;
           }else {
               result+=plusList.get(i);
           }
        }

        for (int i = 0; i < minusList.size(); i++) {
            if(i+1>minusList.size()-1){
                result+=minusList.get(i);
                continue;
            }

            int sum = minusList.get(i)+minusList.get(i+1);
            int mul = minusList.get(i)* minusList.get(i+1);

            if(mul>sum){
                result+=mul;
                i++;
            }else {
                result+=minusList.get(i);
            }
        }

        System.out.println(result);

    }
}