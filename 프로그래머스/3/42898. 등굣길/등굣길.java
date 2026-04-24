import java.util.*;
class Solution {
    static int[][] map;
    static long[][]dp;
    static long div=1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(map[i],1);
        }
        for(int[]p:puddles){
            map[p[1]-1][p[0]-1]=0;
        }
        dp=new long[n][m];
        answer=(int)DP(0,0,m,n);
        return answer;
    }
    
    private long DP(int x,int y,int m,int n){
        if(x==m-1&&y==n-1) return 1;
        if(x>=m||y>=n)return 0;
        if(map[y][x]==0) return 0;
        if(dp[y][x]!=0)return dp[y][x];
        return dp[y][x]=(DP(x+1,y,m,n)+DP(x,y+1,m,n))%div;
    }
}