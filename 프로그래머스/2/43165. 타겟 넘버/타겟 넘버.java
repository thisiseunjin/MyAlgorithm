import java.util.*;
class Solution {
    int resultCnt=0;    //정답의 개수
    public int solution(int[] numbers, int target) {
        //1. 정수들의 순서를 바꾸지 않는다.
        //2. 사용할 수 있는 연산 : + or -
        
        calc(numbers, target, 0,0);
        
        return resultCnt;
        
    }

    public void calc(int[] numbers, int target, int curIdx, int curSum){
        if(curIdx==numbers.length){
            //종료조건 : 끝까지 다 더하거나 했을 경우
            if(curSum==target) resultCnt++;
            return;
        }
        
        
        //더하기를 수행하고 간다.
        calc(numbers, target, curIdx+1, curSum+numbers[curIdx]);
        
        //빼기를 수행하고 간다.
        calc(numbers, target, curIdx+1, curSum-numbers[curIdx]);
    }
}