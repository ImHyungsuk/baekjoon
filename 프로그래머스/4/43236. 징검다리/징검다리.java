import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int l=0,r=distance;
        Arrays.sort(rocks);
        while(l<=r){
            int m=(l+r)/2;
            int cnt=0,min=Integer.MAX_VALUE,prev=0;
            for(int i=0;i<rocks.length;i++){
                int len=rocks[i]-prev;
                if(len<m){
                    cnt++;
                } else {
                    prev=rocks[i];
                    min=Math.min(min,len);
                }
            }
            if(distance-prev<m)cnt++;
            else min=Math.min(min,distance-prev);
            if(cnt>n)r=m-1;
            else {
                l=m+1;
                answer=Math.max(answer,min);
            }
        }
        
        return answer;
    }
}