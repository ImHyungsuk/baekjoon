class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[]visited=new boolean[dungeons.length];
        for(int i=0;i<dungeons.length;i++){
            int tmp=0;
            if(!visited[i]&&k>=dungeons[i][0]){
                visited[i]=true;
                tmp=dfs(k-dungeons[i][1],dungeons,visited);
                visited[i]=false;
            }
            answer=answer<tmp?tmp:answer;
        }
        return answer;
    }
    
    static int dfs(int k, int[][] dungeons, boolean[]visited){
        int cnt=1;
        int max=0;
        for(int i=0;i<dungeons.length;i++){
            int tmp=0;
            if(!visited[i]&&k>=dungeons[i][0]){
                visited[i]=true;
                tmp+=dfs(k-dungeons[i][1],dungeons,visited);
                visited[i]=false;
            }
            max=max<tmp?tmp:max;
        }
        return cnt+max;
    }
}