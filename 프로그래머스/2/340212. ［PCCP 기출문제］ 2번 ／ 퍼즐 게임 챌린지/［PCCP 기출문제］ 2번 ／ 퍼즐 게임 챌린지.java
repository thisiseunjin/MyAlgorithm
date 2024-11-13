import java.util.*;
class Solution {
    int result = 0;
    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1;
        int right = 100000;
        
        int mid =(left+right)/2;
        
        while(left<=right){
            mid = (left+right)/2;
            
            //게임진행 : 제한 시간 내에 풀이 가능? 그럼 right = mid-1, result = mid
            if(isPossible(diffs, times, limit, mid)){
                result = mid;
                right = mid-1;
                continue;
            }
            
            left = mid+1;
            
            
        }
        
        
        return result;
    }
    
    public boolean isPossible(int[] diffs, int[] times, long limit, int level){
        long totalTime = 0;
        
        for(int i=0;i<diffs.length;i++){
            int levelDiff = diffs[i] - level;
            if(levelDiff <=0){
                totalTime += times[i];
                if(totalTime>limit) return false;
                continue;
            }
            
            long spendTime = (times[i-1] + times[i])*levelDiff + times[i];
            
            totalTime += spendTime;
            if(totalTime>limit) return false;
        }
        
        return true;
    }
}