import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        
        int cur = -1;   //현재는 첫 번째까지는 커버 가능
        
        for(int i=0;i<targets.length;i++){
            int s = targets[i][0];
            int e = targets[i][1];
           
            //현재 까지 커버 한 곳보다 e가 크면? 커버 쳐야한다.
            if(s>=cur){
                answer++;
                cur = e;
            }
        }
        
        return answer;
    }
}