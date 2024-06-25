class Solution {
    public int solution(int n) {
        int result = 0;
        
        int cnt = Integer.bitCount(n);
        
        for(int i = n+1; i<(int)1e9;i++){
            int tmp = Integer.bitCount(i);
            if(cnt==tmp){
                result = i;
                break;
            }
        }
        
        return result;
    }
}