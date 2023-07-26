import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        ArrayList<Integer> list = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(s," ");
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        
        answer+=list.get(0);
        answer+=" ";
        answer+=list.get(list.size()-1);
    
        
        return answer;
    }
}