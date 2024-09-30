import java.util.*;
class Solution {
    int result=(int)1e9;
    boolean[] isVisited;
    int N;
    public int solution(String begin, String target, String[] words) {
        isVisited = new boolean[words.length];
        N = words.length;
        
        bfs(begin, target, words);
        
        return result==(int)1e9?0:result;
    }
    
    public void bfs(String begin, String target, String[] words){
        Queue<Word> q = new ArrayDeque<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word word = q.poll();
            
            if(target.equals(word.str)){
                result = Math.min(word.depth, result);
            }
            
            for(int i=0;i<N;i++){
                if(isVisited[i]) continue;  //이미 바꾼 경험이 있으면? 안간다.
                if(!isPossible(word.str, words[i])) continue;

                isVisited[i] = true;
                q.add(new Word(words[i], word.depth+1));
            }
            
        }
    }
    
    class Word{
        String str;
        int depth;
        
        public Word(String str, int depth){
            this.str = str;
            this.depth = depth;
        }
    }
    
    public boolean isPossible(String str, String target){
        //1개의 알파벳만 바꿀 수 있다. -> str와 target의 차가 한글자여야한다.
        //모든 딘어의 길이는 같다.
        int diffCount=0;    //다른 글자의 개수
        for(int i=0;i<str.length();i++){
            char c1 = str.charAt(i);
            char c2 = target.charAt(i);
            
            if(c1==c2) continue;
            if(diffCount>0) return false;
            diffCount++;           
        }
        
        if(diffCount==1) return true;
        return false;
        

    }
}