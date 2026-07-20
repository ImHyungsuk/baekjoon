import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[]visited=new boolean[words.length];
        Queue<Word>q=new LinkedList<>();
        q.add(new Word(begin,0));
        while(!q.isEmpty()){
            Word cur=q.poll();
            if(cur.word.equals(target)){
                answer=cur.cnt;
                break;
            }
            for(int i=0;i<words.length;i++){
                if(visited[i])continue;
                if(available(cur.word,words[i])){
                    visited[i]=true;
                    q.add(new Word(words[i],cur.cnt+1));
                }
            }
        }
        return answer;
    }
    
    
    
    boolean available(String cur, String nxt){
        if(cur.length()!=nxt.length())return false;
        int cnt=0;
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i)!=nxt.charAt(i))cnt++;
            if(cnt>=2)return false;
        }
        return true;
    }
}

class Word{
    String word;
    int cnt;
    
    Word(String word, int cnt){
        this.word=word;
        this.cnt=cnt;
    }
}