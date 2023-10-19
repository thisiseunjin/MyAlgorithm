import java.util.*;

class Solution {
    static int result;
    static class Word{
        String w;
        int depth;
        
        public Word(String w, int depth){
            this.w = w;
            this.depth = depth;
        }
    }
    public int solution(String begin, String target, String[] words) {
        
        bfs(begin, target, words);
            
        return result;
    }
    
    public void bfs(String begin, String target, String[] words){
        boolean[] isVisited = new boolean[words.length];
        Queue<Word> q = new ArrayDeque<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word word = q.poll();
            
            if(word.w.equals(target)){
                result = word.depth;
                return;
            }
            
            for(int i=0;i<words.length;i++){
                if(isVisited[i]) continue;
                if(!isPossible(word.w, words[i])) continue;
                isVisited[i] = true;
                q.add(new Word(words[i], word.depth+1));
            }
            
        }
        
    }
    
    public boolean isPossible(String str, String target){
        
        //가능한 조건
        //1. 한번에 한개의 알파벳만 바꿀 수 있다.
        //2. words에 있는 단어로반 변환할 수 있다.
        
        int diff = 0;
        for(int i=0;i<target.length();i++){
            char t = target.charAt(i);
            
            char s = str.charAt(i);
            
            if(t!=s) diff++;
            
            if(diff==2) return false;
        }
        
        return true;
    
    }
}