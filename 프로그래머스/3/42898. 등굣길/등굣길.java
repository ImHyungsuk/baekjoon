class Solution {
    static int div=1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][]dp=new long[n][m];
        boolean[][]water=new boolean[n][m];
        for(int i=0;i<puddles.length;i++){
            water[puddles[i][1]-1][puddles[i][0]-1]=true;
        }
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(water[i][j]){
                    dp[i][j]=0;
                    continue;
                }
                if(i>0)
                    dp[i][j]=(dp[i][j]+dp[i-1][j])%div;
                if(j>0)
                    dp[i][j]=(dp[i][j]+dp[i][j-1])%div;
            }
        }
        answer=(int)dp[n-1][m-1];
        return answer;
    }
}