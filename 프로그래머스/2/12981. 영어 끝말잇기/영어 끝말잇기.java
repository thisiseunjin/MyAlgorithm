import java.util.*;
class Solution {
    int[] ans = new int[2];
    Set<String> set = new HashSet<>();
    public int[] solution(int n, String[] words) {
        
        String pre = words[0];
        set.add(pre);
        
        for(int i=1;i<words.length;i++){
            String word = words[i];
            
            //1. 끝말잇기가 되는지 검사
            char ch1 = pre.charAt(pre.length()-1);
            char ch2 = word.charAt(0);
            if(ch1!=ch2){
                ans[0] = (i%n)+1;
                ans[1] = (i/n)+1;
                break;
            }
            
            
            //2. 중복되는 글자가 있는지 먼저 검사
            if(set.contains(word)){
                ans[0] = (i%n)+1;
                ans[1] = (i/n)+1;
                break;
            }
            
            set.add(word);
            pre = word;
        }
        
     
        return ans;
    }
}