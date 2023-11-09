class Solution {
    static int[] parents;
    static boolean[] isChecked;
    static int result=0;
    
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        isChecked = new boolean[n];
        
        //초기값은 자기 자신이다.
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //i와 연결된 친구들임!
                if(i==j) continue;
                if(computers[i][j]==1) union(i,j);
                
            }
        }
        
        
        for(int i=0;i<n;i++){
            int p = find(i);
            if(isChecked[p]) continue;
            isChecked[p] = true;
            result++;
        }
        
        
        return result;
    }
    
    public int find(int a){
        //부모 찾기 시작~!
        
        if(a==parents[a]) return a;
        
        //계속 부모를 찾으려고 올라간다.
        return parents[a] = find(parents[a]);
    }
    
    public void union(int a, int b){
        
        int rootA = parents[a];
        int rootB = parents[b];
        
        if(rootA == rootB) return;  //둘을 같은 노드에 있다.
        
        //작은 쪽이 부모가 된다.
        if(rootA>rootB){
            parents[b] = rootA;
        }else parents[a] = rootB;
    }
}