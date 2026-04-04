class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len=triangle.length;
        int [][]dp=new int[len][len];
        for(int i=0;i<len;i++){
            answer=Math.max(answer,DP(i,len-1,triangle,dp));
        }
        return answer;
    }
    
    static int DP(int x,int y,int[][]triangle,int [][]dp){
        if(dp[y][x]!=0)return dp[y][x];
        
        int cur=triangle[y][x];
        if(y==0)return cur;
        
        if(x==0)return dp[y][x]=Math.max(dp[y][x],cur+DP(x,y-1,triangle,dp)) ;
        if(x==triangle[y].length-1)return dp[y][x]=Math.max(dp[y][x],cur+DP(x-1,y-1,triangle,dp));
        
        return dp[y][x]=Math.max(dp[y][x],(cur+Math.max(DP(x-1,y-1,triangle,dp),DP(x,y-1,triangle,dp))));
    }
}