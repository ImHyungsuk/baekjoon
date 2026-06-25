class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h=triangle.length;
        int[][]dp=new int[h][h];
        dp[0][0]=triangle[0][0];
        for(int i=0;i<h;i++){
            for(int j=0;j<=i;j++){
                if(dp[i][j]!=0)continue;
                if(j==0)dp[i][j]=dp[i-1][j]+triangle[i][j];
                else if(j==i)dp[i][j]=dp[i-1][j-1]+triangle[i][j];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
            }
        }
        for(int i=0;i<h;i++){
            answer=Math.max(answer,dp[h-1][i]);
        }
        return answer;
    }
}