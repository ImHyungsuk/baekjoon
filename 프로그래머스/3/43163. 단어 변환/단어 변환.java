import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int l=words.length;
        boolean[] visited=new boolean[l];
        Queue<Word>q=new LinkedList<>();
        q.add(new Word(begin,0));
        while(!q.isEmpty()){
            Word cur=q.poll();
            // System.out.println("target = "+target+" cur.value = "+cur.value+" cnt = "+cur.cnt);
            if(cur.value.equals(target)){
                    // System.out.println("target = "+cur.value+" cnt = "+cur.cnt);
                answer=cur.cnt;
                break;
            }
            for(int i=0;i<l;i++){
                if(!visited[i]&&available(cur.value,words[i])){
                    visited[i]=true;
                    q.add(new Word(words[i],cur.cnt+1));
                    // System.out.println("insert "+words[i]);
                }
            }
        }
        return answer;
    }
    
    boolean available(String cur,String nxt){
        if(cur.length()!=nxt.length())return false;
        int len=cur.length();
        int cnt=0;
        for(int i=0;i<len;i++){
            if(cur.charAt(i)!=nxt.charAt(i)){
                cnt++;
            }
            if(cnt>=2)return false;
        }
        return true;
    }
}

class Word{
    String value;
    int cnt;
    public Word(String value,int cnt){
        this.value=value;
        this.cnt=cnt;
    }
}