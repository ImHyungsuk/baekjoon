class Solution {
    static int answer=Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[]visited=new boolean[words.length];
        dfs(begin,target,words,visited,0);
        answer=answer==Integer.MAX_VALUE?0:answer;
        return answer;
    }
    
    void dfs(String cur, String target, String[] words,boolean[]visited,int cost){
        if(cur.equals(target)){
            answer=Math.min(answer,cost);
        }
        for(int i=0;i<words.length;i++){
            if(visited[i])continue;
            if(available(cur,words[i],target)){
                visited[i]=true;
                dfs(words[i],target,words,visited,cost+1);
                visited[i]=false;
            }
        }
    }
    
    boolean available(String from, String to,String target){
        int l=from.length();
        if(l!=to.length())return false;
        int cnt=0;
        for(int i=0;i<l;i++){
            if(from.charAt(i)!=to.charAt(i)){
                cnt++;
                if(cnt>1) return false;
            }
        }
        return true;
    }
}