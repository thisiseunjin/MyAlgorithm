class Solution {
    static String[] words = {"zero","one","two","three","four","five","six","seven","eight", "nine"};
    public int solution(String s) {
        
        int index = 0;
        String target ="";
        String result="";
        
        while(index<s.length()){
            // System.out.println(index);
            // System.out.println(target);

            //1. 숫자이다.
            char ch = s.charAt(index++);
            if(ch>='a' && ch<='z'){
                target+=ch+"";
               
                String converted = convert(target);
                if(!converted.equals("")){
                    target="";
                    result+=converted;
                }
                
                continue;
            }
            
            // if(!target.equals("")){
            //     System.out.println(target);
            //     result+=convert(target);
            //     target="";
            // }
            
            result += ch+"";
            
        }
        
        return Integer.parseInt(result);
    }
    
    public String convert(String str){
        for(int i=0;i<10;i++){
            if(str.equals(words[i])){
                return i+"";
            }    
        }
        return "";
    }
}