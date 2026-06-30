import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long l=0,r=(long)times[times.length-1]*n;
        while(l<=r){
            long m=(l+r)/2;
            long cnt=0;
            for(int i=0;i<times.length;i++){
                cnt+=m/times[i];
            }
            if(cnt<n){
                l=m+1;
            }else{
                answer=m;
                r=m-1;
            }
        }
        return answer;
    }
}