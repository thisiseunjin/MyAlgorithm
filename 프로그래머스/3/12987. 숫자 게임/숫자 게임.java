import java.util.*;
class Solution {
    
    /*
    - 숫자가 큰 쪽이 이기는거임.
    - A팀은 이미 순서 정함
    */

        
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        //걍 이길 수 있는지 비교 ㄱㄱ
        
        
      
        return count(A,B);
    }
    
    public int count(int[] A, int[] B){
        int count=0;
        int indexA =0;
        int indexB = 0;
        
        for(int i=0;i<A.length;i++){
            if(A[indexA]>=B[indexB]) indexB++;
            else{
                indexB++;
                indexA++;
                count++;
            }
            
        }
        
        return count;
    }
    
    
}