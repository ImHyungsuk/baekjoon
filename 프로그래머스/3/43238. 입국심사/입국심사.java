
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long l=1,r=1_000_000_000_000_000_000L;
        while(l<=r){
            long cnt=0;
            long mid=(l+r)/2;
            for(int t:times){
                cnt+=mid/(long)t;
            }
            if(cnt<n){
                l=mid+1;
            }else{
                answer=mid;
                r=mid-1;
            }
        }
        return answer;
    }
}