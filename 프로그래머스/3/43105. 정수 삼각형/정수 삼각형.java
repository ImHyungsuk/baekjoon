class Solution {
    static int [][]dp;
    static int n;
    public int solution(int[][] triangle) {
        int answer = 0;
        n=triangle.length;
        dp=new int[n][];
        for(int i=0;i<n;i++){
            dp[i]=new int[i+1];
        }
        answer=DP(0,0,triangle);
        return answer;
    }
    static int DP(int y,int x,int[][]triangle){
        if(y==n-1)return dp[y][x]=triangle[y][x];
        if(dp[y][x]==0)
            dp[y][x]=Math.max(DP(y+1,x,triangle),DP(y+1,x+1,triangle))+triangle[y][x];
        return dp[y][x];
    }
}