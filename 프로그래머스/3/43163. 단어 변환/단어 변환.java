import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE-1;
        int len=target.length();
        int words_len=words.length;
        boolean[]visited=new boolean[words_len];
        char[]arr=new char[len];
        Queue<String>q=new ArrayDeque<>();
        q.add(begin);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur=q.poll();
                if(cur.equals(target)) answer=Math.min(level,answer);
                for(int j=0;j<words_len;j++){
                    int idx;
                    if(!visited[j]&&canChange(cur,words[j])){
                        q.add(words[j]);
                        visited[j]=true;
                    }
                }
            }
            level++;
        }
        return (answer==Integer.MAX_VALUE-1)?0:answer;
    }
    
    static boolean canChange(String cur, String next){
        int len=cur.length();
        int cnt=0;
        int idx=-1;
        for(int i=0;i<len;i++){
            if(cur.charAt(i)!=next.charAt(i)) {
                cnt++;
            }
        }
        if(cnt==1)return true;
        else return false;
    }
}