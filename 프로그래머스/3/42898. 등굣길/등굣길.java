class Solution {
    static long div=1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][]dp=new long[n+1][m+1];
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]]=-1;
        }
        answer=(int)(DP(dp,m,n)%div);
        return answer;
    }
    
    long DP(long[][]dp,int x, int y){
        if(x<=0||y<=0||dp[y][x]==-1)return 0;
        if(x==1&&y==1)return 1;
        return dp[y][x] = (dp[y][x] != 0 ? dp[y][x] : DP(dp,x-1,y)+DP(dp,x,y-1))%div;
    }
}