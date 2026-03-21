class Solution {
    public int[] solution(int[] prices) {
        int n=prices.length;
        int[] answer = new int[n];
        boolean[]isEnd=new boolean[n];
        for(int i=0;i<n;i++){
            int j=i+1;
            while(j<n&&prices[i]<=prices[j]){
                j++;
            }
            if(j==n){
                answer[i]=j-i-1;
            }else{
                answer[i]=j-i;
            }
        }
        
        return answer;
    }
}