import java.util.*;
import java.io.*;

class Solution
{
    //누적된 값이 최소가 되도록 만드는 것이 목표임. 한번 뽑은 숫자는 다시 뽑을 수 없음.
    public int solution(int []A, int []B)
    {
        boolean[] isSelectedA = new boolean[A.length];
        boolean[] isSelectedB = new boolean[B.length];
        int result = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0;i<A.length;i++){
            //제일 작은거랑 제일 큰거랑 곱해준다
            int tmp = A[i] * B[B.length-1-i];
            result+=tmp;
        }

        return result;
    }
}