class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int n=arr.length/2+1;
        int []nums=new int [n];
        String[]ops=new String[n-1];
        for(int i=0;i<arr.length;i++){
            if(i%2==0)nums[i/2]=Integer.parseInt(arr[i]);
            else ops[i/2]=arr[i];
        }
        
        int[][]maxDp=new int[n][n];
        int[][]minDp=new int[n][n];
        for(int i=0;i<n;i++){
            maxDp[i][i]=nums[i];
            minDp[i][i]=nums[i];
        }
        
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                
                maxDp[i][j]=Integer.MIN_VALUE;
                minDp[i][j]=Integer.MAX_VALUE;
                
                for(int k=i;k<j;k++){
                    String op=ops[k];
                    
                    if(op.equals("+")){
                        maxDp[i][j]=Math.max(maxDp[i][j],maxDp[i][k]+maxDp[k+1][j]);
                        minDp[i][j]=Math.min(minDp[i][j],minDp[i][k]+minDp[k+1][j]);
                    }else{
                        maxDp[i][j]=Math.max(maxDp[i][j],maxDp[i][k]-minDp[k+1][j]);
                        minDp[i][j]=Math.min(minDp[i][j],minDp[i][k]-maxDp[k+1][j]);
                    }
                }
            }
        }
        answer=maxDp[0][n-1];
        return answer;
    }
}