import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int[] order = new int[priorities.length]; //순서를 저장할 배열
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : priorities){
            pq.add(i);
        }
        
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            q.add(i);
        }
        
        int turn=0;
        while(!q.isEmpty()){
            int idx = q.poll();
            
            //내가 뽑은 친구의 우선순위는?
            int priority = priorities[idx];
            
            //내가 뽑은게 우선순위가 높따?
            if(pq.peek()==priority){
                pq.poll();
                order[idx] = turn++;
                continue;
            }
            
            //내가 뽑은게 우선순위가 낮따?
            //그럼 다시 넣지 뭥,,,
            q.add(idx);
        }
        
        System.out.println(Arrays.toString(order));
        return order[location]+1;
        
    }
}