import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Solution {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
 
        int T= Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
 
            int ans = 0;
 
            st = new StringTokenizer(br.readLine());
 
            // 첫번째 집합 문자열 개수
            int n = Integer.parseInt(st.nextToken());
 
            // 두번째 집합 문자열 개수
            int m = Integer.parseInt(st.nextToken());
 
            HashSet<String> first = new HashSet<>();
 
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                first.add(st.nextToken());  // O(1)
            }
 
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                if(first.contains(st.nextToken())) ans++;  // O(1)
            }
 
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
 
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}