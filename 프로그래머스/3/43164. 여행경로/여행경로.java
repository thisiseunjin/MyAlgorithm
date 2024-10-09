import java.util.*;

class Solution {
    HashMap<String, ArrayList<Ticket>> map = new HashMap<>();
    boolean[] isVisited;
    String[] result = {};
    boolean isFind = false;
    public String[] solution(String[][] tickets) {
        
        isVisited = new boolean[tickets.length];
        
        for(int i=0;i<tickets.length;i++){
            String from = tickets[i][0];
            String to = tickets[i][1];
            
            ArrayList<Ticket> list;
            
            if(map.get(from)==null){
                list = new ArrayList<>();
            }else{
                list = map.get(from);
            }
            
            list.add(new Ticket(to, i));
            map.put(from, list);
        }
        
        //list정렬한다
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            ArrayList<Ticket> list = map.get(key);
            Collections.sort(list);
            map.put(key, list);
            
            // System.out.println(list.toString());
        }
        
        List<Ticket> list = map.get("ICN");
        for(Ticket t : list){
            ArrayList<String> route = new ArrayList<>();
            route.add("ICN");
            route.add(t.airport);
            isVisited[t.idx] = true;
            dfs(t, route);
            isVisited[t.idx] = false;
        }
        
        
        return result;
    }
    
    public void dfs(Ticket now, ArrayList<String> list){
        
        if(isFind){
            return;
        }
        
        if(isDone()){
            result = new String[list.size()];
            for(int i=0;i<list.size();i++){
                result[i] = list.get(i);
            }
            
            isFind = true;
            return;
        }
        
        if(map.get(now.airport)==null) return;
        
        //갈수 있는 곳을 간다.
        for(Ticket t : map.get(now.airport)){
            
            //이미 사용한 티켓이면 갈 수 없다.
            if(isVisited[t.idx]) continue;
            isVisited[t.idx] = true;
            ArrayList<String> newList = new ArrayList<>(list);
            newList.add(t.airport);
            dfs(t,newList);
            isVisited[t.idx] = false;
        }
    }
    
    boolean isDone(){
        for(int i=0;i<isVisited.length;i++){
            if(!isVisited[i]) return false;
        }
        
        return true;
    }
    
    class Ticket implements Comparable<Ticket> {
        String airport;
        int idx;
        
        public Ticket(String airport, int idx){
            this.airport = airport;
            this.idx = idx;
        }
        
        public int compareTo(Ticket t) {
         return this.airport.compareTo(t.airport);
        }
        
        public String toString(){
            return airport;
        }

    }
}