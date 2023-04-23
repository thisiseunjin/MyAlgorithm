import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        // str1과 str2를 모두 소문자로 변경한다.

        ArrayList<String> set1 = makeSet(str1.toLowerCase());
        ArrayList<String> set2 = makeSet(str2.toLowerCase());
        
        int intersection =0;
        boolean[] isSelected = new boolean[set2.size()];
        
          for(int i=0;i<set1.size();i++){
              System.out.print(set1.get(i)+"  ");
          }
        
        System.out.println();
        
          for(int i=0;i<set2.size();i++){
              System.out.print(set2.get(i)+"  ");
          }
        
        
        for(int i=0;i<set1.size();i++){
            for(int j=0;j<set2.size();j++){
                if(!set1.get(i).equals(set2.get(j))) continue;
                if(isSelected[j]) continue;
                System.out.println(i+"  "+j);
                intersection++;
                isSelected[j] = true;
                break;
            }
            
        }
        
        System.out.println(intersection);
        
        int union = set1.size()+ set2.size() - intersection;
        
         System.out.println(union);
        
        if(intersection==0 && union!=0) return 0;
        
        if(union ==0) return 65536;
        
        answer = (int)Math.ceil(intersection* 65536/union) ;
        
        if(answer ==0) return 65536;
        
        return answer;
    }
    
    //집합을 만들어 주는 함수이다. 
    public ArrayList<String> makeSet(String str){
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0;i<str.length()-1;i++){
            if(!Character.isAlphabetic(str.charAt(i))) continue;
            if(!Character.isAlphabetic(str.charAt(i+1))) continue;
            
            list.add(str.substring(i,i+2));
        }
        
        return list;
    }
}