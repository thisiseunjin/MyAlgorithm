import java.util.*;
import java.io.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int result =0;
        int cnt=0;
        
        
        for(int i=0;i<list.size();i++){
            result+=1;
            cnt+=list.get(i);
            if(cnt>=k) break;
        }
        return result;
    }
}