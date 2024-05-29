import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> list = new ArrayList<>();
        
        if(cacheSize==0){
            return cities.length * 5;
        }
        
        int time = 0;
        //LRU : 최근에 가장 적게 사용된 친구를 지울 꺼임ㅋ
        
        for(String city : cities){
            
            city = city.toLowerCase();
            //캐시에 존재할 경우
            
            if(list.contains(city)){
                list.remove(city);
                list.add(city);
                time+=1;
                continue;
            }
            
            //캐시에 추가해야 하는데 크기가 클 경우
            if(list.size()==cacheSize){
                list.remove(0);
            }
            
            list.add(city);
            time+=5;

        }
        
        return time;
    }
}