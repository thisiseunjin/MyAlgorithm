class Solution {
    boolean[] isSelected;
    int[] selected;
    int N;
    int result = 0;
    int K;
    
    public int solution(int k, int[][] dungeons) {
        //최소피로도 : 해당 던전을 탐험하기 위해 가지고 있어야할 최소한의 피로도
        //소모 피로도 : 던전을 탐험하면 소모되는 피로도
        int answer = 0;
        
        K = k;
        N = dungeons.length; //던전의 개수
        isSelected = new boolean[N];
        selected = new int[N];        
        
        permutation(0, dungeons);
        
        return result;
    }
    public void permutation(int cnt, int[][] dungeons){
        if(cnt==N){
            result = Math.max(result, countDungenos(dungeons));
            return;
        }
        
        for(int i=0;i<N;i++){
            //선택 되어 있다면? 못감~!~!
            if(isSelected[i]) continue;
            
            //선택안했으면? 선택 하고 간다.
            isSelected[i] = true;
            selected[cnt] = i;
            permutation(cnt+1, dungeons);
            isSelected[i] = false;
        }
        
    }
    
    public int countDungenos(int[][] dungeons){
        int power = K;
        int cnt = 0;
        
        // selected {1,3,2};
        for(int i=0;i<N;i++){
            int curIdx = selected[i]; //1,3,2
            
            //지금 내가 가야하는 던전의 최소 필로 필요도가 나보다 큰가?
            if(dungeons[curIdx][0]>power) break;
            
            power-=dungeons[curIdx][1];
            cnt+=1;
        }
        
        return cnt;
        
    }
}