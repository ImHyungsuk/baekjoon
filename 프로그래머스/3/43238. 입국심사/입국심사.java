import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int len=times.length;
        Arrays.sort(times);
        long min=1,max=(long)times[len-1]*n;
        while(min<=max){
            long mid=(min+max)/2;
            
            long sum=calculateTime(times,mid,n);
            
            if(sum>=n) {
                answer=mid;
                max=mid-1;
            }
            else min=mid+1;
        }
        return answer;
    }
    
    static long calculateTime(int []times,long t,int n){
        long ret=0;
        for(int time:times){
            ret+=(t/time);
            // if(ret>=n)break;
        }
        return ret;
    }
}