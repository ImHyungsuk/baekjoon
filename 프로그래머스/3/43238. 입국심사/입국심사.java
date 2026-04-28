import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        int len=times.length;
        long max=(long)times[len-1]*n;
        long l=1,r=max;
        while(l<=r){
            long mid=(l+r)/2;
            long cnt=0;
            for(int t:times){
                cnt+=mid/t;
            }
            if(cnt>=n){
                answer=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return answer;
    }
}