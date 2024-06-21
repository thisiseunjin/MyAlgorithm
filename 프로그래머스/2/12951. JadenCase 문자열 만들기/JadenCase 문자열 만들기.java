import java.util.*;
import java.io.*;


class Solution {
    public String solution(String s) {
        String result = "";
        StringTokenizer st = new StringTokenizer(s, " ",true);
        StringBuilder sb = new StringBuilder();
        
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            
            if(str.equals(" ")){
                sb.append(" ");
                continue;
            }
            str = str.toLowerCase();
            if(Character.isAlphabetic(str.charAt(0))){
                 str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
            }
            sb.append(str);
           
        }
        return sb.toString();
    }
}