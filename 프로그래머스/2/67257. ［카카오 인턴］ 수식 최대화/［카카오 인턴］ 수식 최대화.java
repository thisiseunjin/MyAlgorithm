import java.util.*;
class Solution {
    // 연산자는 + - *만 나온다
    char[] operation = {'+', '-', '*'};
    char[] order = new char[3];
    ArrayList<Long> numList = new ArrayList<>();
    ArrayList<Character> opList = new ArrayList<>();
    boolean[] isSelected = new boolean[3];
    long result=0;
    
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+,-,*", true);
       
        while(st.hasMoreTokens()){
            // input.add(st.nextToken());
            String s = st.nextToken();
            if(s.equals("+")||s.equals("-")||s.equals("*")) opList.add(s.charAt(0));
            else numList.add(Long.parseLong(s));
        }
        
        permutation(0);
        
        return result;
    }
    
    public void permutation(int cnt){
        if(cnt==3){
            // System.out.println("==========="+Arrays.toString(order) + "===========");
            //선택 완료 이제 계산 하면 됨.
            //우선순위 선택 완료 한 것임.
            result = Math.max(result, calc());
            return;
        }
        
        for(int i=0;i<3;i++){
            if(isSelected[i]) continue;
            
            //넣고 간다
            isSelected[i] = true;
            order[cnt] = operation[i];
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }
    
    public long calc(){
        ArrayList<Long> nList  = new ArrayList<>();
        ArrayList<Character> oList = new ArrayList<>();
        
        for(long n : numList){
            nList.add(n);
        }
        
        for(char c : opList){
            oList.add(c);
        }
       
        
        for(int i=0;i<3;i++){
            //우선순위 1등부터 for문을 돌며 확인을 진행해준다.
            while(true){
                boolean flag = false;
                for(int j=0;j<oList.size();j++){
                    if(oList.get(j)!=order[i]) continue;
                    
                    char o = oList.get(j);
                    long tmp =0;
                    switch (o){
                        case '+':
                            tmp = nList.get(j)+nList.get(j+1);
                            break;
                         case '-':
                            tmp = nList.get(j)-nList.get(j+1);
                            break;
                         case '*':
                            tmp = nList.get(j)*nList.get(j+1);
                            break;
                    }
                   
                    nList.set(j, tmp);
                    nList.remove(j+1);
                    flag = true;
                    oList.remove(j);
                    break;
                }
                
                if(!flag) break;
            }
        }
        return Math.abs(nList.get(0));
    }
   
}