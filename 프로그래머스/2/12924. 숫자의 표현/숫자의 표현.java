class Solution {
    public int solution(int n) {
        
        int cnt=1;
        
        for(int start=1;start<n/2+1;start++){
            int sum =0;
            for(int i=start; i<n;i++){
                sum+=i;
                if(sum==n){
                    cnt++;
                    break;
                }
                
                if(sum>n) break;
            }
        }
        
        
        
        return cnt;
    }
}