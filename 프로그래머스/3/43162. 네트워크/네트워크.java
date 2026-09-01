class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[]visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                dfs(i,n,computers,visited);
            }
        }
        return answer;
    }
    void dfs(int cur,int n,int[][]computers,boolean[]visited){
        for(int nxt=0;nxt<n;nxt++){
            if(nxt==cur)continue;
            if(!visited[nxt]&&computers[cur][nxt]==1){
                visited[nxt]=true;
                dfs(nxt,n,computers,visited);
            }
        }
    }
}

