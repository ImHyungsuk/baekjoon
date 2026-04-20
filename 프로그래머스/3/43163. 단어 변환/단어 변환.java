import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean flag=false;
        for(int i=0;i<words.length;i++){
            if(target.equals(words[i])){
                flag=true;
                break;
            }
        }
        if(!flag) return answer;
        answer=bfs(begin,target,words);
        
        return answer;
    }
    
    public int bfs(String begin, String target, String []words){
        int len=words.length;
        int cnt=len;
        boolean[]visited=new boolean[len];
        Queue<Word>q=new LinkedList<>();
        q.add(new Word(begin,0));
        while(!q.isEmpty()){
            Word cur=q.poll();
            if(cur.word.equals(target)){
                cnt=Math.min(cnt,cur.cost);
            }
            for(int i=0;i<len;i++){
                if(visited[i])continue;
                if(getDiff(cur.word,words[i])){
                    visited[i]=true;
                    q.add(new Word(words[i],cur.cost+1));
                }
            }
        }
        return cnt;
    }
    
    public boolean getDiff(String current, String next){
        int len=current.length();
        int cnt=0;
        if(len!=next.length())return false;
        for(int i=0;i<len;i++){
            if(current.charAt(i)!=next.charAt(i))cnt++;
            if(cnt>1)return false;
        }
        return true;
    }
}

class Word{
    String word;
    int cost;
    public Word(String word,int cost){
        this.word=word;
        this.cost=cost;
    }
}