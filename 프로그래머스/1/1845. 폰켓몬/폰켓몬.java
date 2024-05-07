import java.util.*;

class Solution {
    int N;
    Set<Integer> set = new HashSet<>();

    public int solution(int[] nums) {
        N = nums.length;
        for(int i : nums){
            // System.out.println(i);
            set.add(i);
        }
        
        if(set.size()>N/2){

            return N/2;
        }else{
            return set.size();
        }
    
    }
    
    
}