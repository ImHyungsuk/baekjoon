import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Word>q=new LinkedList<>();
        boolean[] visited=new boolean[words.length];
        q.add(new Word(0,begin));
        while(!q.isEmpty()){
            Word cur=q.poll();
            if(cur.str.equals(target))return cur.num;
            for(int i=0;i<words.length;i++){
                if(visited[i])continue;
                if(changeAvailable(cur.str,words[i])){
                    visited[i]=true;
                    q.add(new Word(cur.num+1,words[i]));
                }
            }
            
        }
        return answer;
    }
    
    private boolean changeAvailable(String cur, String next){
        int len=cur.length();
        int cnt=0;
        for(int i=0;i<len;i++){
            if(cur.charAt(i)!=next.charAt(i)) cnt++;
            if(cnt>1)return false;
        }
        return true;
    }
}

class Word{
    int num;
    String str;
    Word(int num, String str){
        this.num=num;
        this.str=str;
    }
}