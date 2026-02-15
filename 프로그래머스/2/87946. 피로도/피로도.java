class Solution {
    static boolean[]visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int len=dungeons.length;
        visited=new boolean[len];
        
        for(int i=0;i<len;i++){
            if(!visited[i]&&k>=dungeons[i][0]){
                visited[i]=true;
                answer=Math.max(answer,dfs(k-dungeons[i][1],len,dungeons));
                visited[i]=false;
            }
        }
        return answer;
    }
    
    static int dfs(int k,int len,int[][]dungeons){
        int cnt=1;
        for(int i=0;i<len;i++){
            if(!visited[i]&&k>=dungeons[i][0]){
                visited[i]=true;
                cnt=Math.max(cnt, dfs(k-dungeons[i][1],len,dungeons)+1);
                visited[i]=false;
            }
        }
        return cnt;
    }
}