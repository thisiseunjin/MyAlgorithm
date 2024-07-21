import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        stack.push(s.charAt(0));
        
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            
            //스택에서 하나 뽑는다.
            
            //스택에 있는거랑 나랑 다르다? 나도 스택으로 들어간다.
            if(stack.isEmpty() || stack.peek()!=ch){
                stack.push(ch);
                continue;
            }
            
            //스택에 있는거랑 나랑 같다? 걍 없애고 간다.
            stack.pop();
            
        }
        
        
        return stack.size()==0?1:0;
    }
}