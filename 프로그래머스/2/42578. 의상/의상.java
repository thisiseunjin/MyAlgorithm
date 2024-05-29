import java.util.*;
class Solution {
    
    //서로 다른 옷의 조합의 수를 출력하세요~!
    
    public int solution(String[][] clothes) {
    
        
        int result = 1; //1개는 입고 돌아다니는거 아잉교
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] str : clothes){
            String key = str[1];
            map.put(key, map.getOrDefault(key,0)+1);
        }
        
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()){
            result *= it.next().intValue()+1;
        }
        return result-1;
    }
}