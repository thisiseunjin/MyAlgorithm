class Solution {
    //조건 : 문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
    public int solution(String s) {
        
        int min = s.length();
        for(int i=1;i<=s.length()/2;i++){
            int cnt = convert(s,i);
            min = Math.min(cnt, min);
        }
        return min;
    }
    
    public int convert(String s, int n){
        
        int toalLength = s.length();
        
        int patternCount =0;
    
        
        String pattern = s.substring(0,n);   //가장 첫 시작은 0~n까지가 패턴이 된다.
        
        //1. 자 패턴이 완성 되었다, 다음 문자열이 내 패턴과 일치하는가?
        //2. 일치 하지 않는다면? 다음 문자열이 내 패턴이 된다.
        for(int i=n;i<s.length();i+=n){
            
            
            if(i+n > s.length()) {
                break;
            }
            
            String str = s.substring(i, i+n);
            
            if(pattern.equals(str)){
                patternCount++;
                continue;
            }
            
            if(patternCount>0) {
                toalLength-=(n*patternCount);
                String num = (patternCount+1)+"";
                toalLength+=num.length();
                patternCount=0;
            }
            
            pattern = str;

        }
        
        if(patternCount>0) {
            toalLength-=(n*patternCount);
            String num = (patternCount+1)+"";
            toalLength+=num.length();
            patternCount=0;
        }
        
        return toalLength;
        
    }
}



