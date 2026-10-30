import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int l=0,r=distance;
        Arrays.sort(rocks);
        int len=rocks.length;
        while(l<=r){
            int m=(r+l)/2;
            int cnt=0,prev=0;
            for(int i=0;i<len;i++){
                if(cnt>n)break;
                if(rocks[i]-prev<m){
                    cnt++;
                    continue;
                }
                prev=rocks[i];
            }
            if(distance-prev<m)cnt++;
            // System.out.println(l+" ~ "+r+": "+cnt);
            
            if(cnt<=n) {
                l=m+1;
                answer=Math.max(answer,m);
            }
            else {
                r=m-1;
            }
        }
        return answer;
    }
}