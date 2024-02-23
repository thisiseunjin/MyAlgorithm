import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());    //테스트 케이스의 수
        for (int test = 0; test < T; test++) {
            ArrayList<Person> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            int count=0;
            
            //1. 사람 수 만큼 돈다.
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());

                list.add(new Person(s1, s2));
            }

            Collections.sort(list);

            //둘다 작은놈 있으면 조짐.
            int score1 = list.get(0).s1;
            int score2 = list.get(0).s2;
            for (int i = 1; i < N; i++) {
                //둘다 크면 뽑는다.
                Person p = list.get(i);
                if(score1<p.s1 && score2<p.s2) count++;
                else{
                    score1 = p.s1;
                    score2 = p.s2;
                }
            }
            sb.append(N-count).append("\n");
        }

        System.out.println(sb);
    }

    static class Person implements Comparable<Person>{
        int s1; //서류 성적
        int s2; //면접 성적
        public Person(int s1, int s2){
            this.s1 = s1;
            this.s2 = s2;
        }


        @Override
        public int compareTo(Person o) {
            return this.s1!=o.s1 ? this.s1-o.s1:this.s2-o.s2;
        }
    }
}