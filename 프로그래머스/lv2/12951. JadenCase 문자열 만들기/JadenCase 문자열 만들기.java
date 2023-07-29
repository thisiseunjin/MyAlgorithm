import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] words = s.split(" ", -1);

        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(change(word));
            }
            sb.append(" ");
        }
        
        // 마지막 공백 삭제
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
    public String change(String str) {
        String s1 = str.substring(0, 1).toUpperCase();
        String s2 = str.substring(1).toLowerCase();

        return s1 + s2;
    }
}
