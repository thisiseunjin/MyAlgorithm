import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idMap = new HashMap<>(); 
        int count = 0;
        
        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(" ");
            
            if(info[0].equals("Leave")){       
                continue;
            } else if(info[0].equals("Enter")){ 
                idMap.put(info[1], info[2]);
            } else {                            
                idMap.put(info[1], info[2]);
                count++;
            }
        }
        
        String[] answer = new String[record.length - count];
        int idx = 0;
        
        for(int i = 0; i < record.length; i++){
            String[] info = record[i].split(" ");
            String nickname = idMap.get(info[1]);
            
            if(info[0].equals("Enter")){                     
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if(info[0].equals("Leave")){              
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}