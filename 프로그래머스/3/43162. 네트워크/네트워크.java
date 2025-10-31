class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean []visited=new boolean[n];
        
        for(int i=0;i<computers.length;i++){
            if(!visited[i]){
                answer++;
                visited[i] = true;
                dfs(computers, i,visited);
            }
        }
        
        return answer;
    }
    
    static void dfs(int[][]computers,int idx,boolean[]visited){
        for(int j=0;j<computers[idx].length;j++){
            if(idx==j) continue;
            if(!visited[j]&&computers[idx][j]==1){
                visited[j]=true;
                dfs(computers,j,visited);
            }
        }
    }
}