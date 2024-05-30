import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int curIdx = 0;
        int sum=0;
        
        while(sum<progresses.length){
            
            //전체 친구들 1일씩 다 더해주기
            for(int i = curIdx;i<progresses.length;i++){
                progresses[i]+=speeds[i];
            }
            
            //만약 내가 완성 되지 못한다면? 뒤로 못간다.
            if(progresses[curIdx]<100) continue;
            
            if(curIdx==progresses.length-1){
                list.add(1);
                break;
            }
            
            int cnt=0;
            
            //나 이제 배포할 수 있음!
            for(int j = curIdx;j<progresses.length;j++){
                if(progresses[j]>=100){
                    cnt+=1;
                    continue;
                }
                
                curIdx = j;
                break;
            }
            
            sum+=cnt;
            list.add(cnt);
        }
        
        
        
        return getArray(list);
    }
    
    public int[] getArray(ArrayList<Integer> list){
        int[] result = new int[list.size()];
        
        for(int i=0 ; i<list.size() ; i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}