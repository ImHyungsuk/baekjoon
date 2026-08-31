import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int l=1,r=distance;
        while(l<=r){
            int mid=(l+r)/2;
            int cnt=0;
            int prev=0;
            for(int rock:rocks){
                if(cnt>n)break;
                if(rock-prev<mid) {
                    cnt++;
                    continue;
                }
                prev=rock;
            }
            if(distance-prev<mid) cnt++;
            
            if(cnt>n){
                r=mid-1;
            }else{
                answer=mid;
                l=mid+1;
            }
        }
        
        return answer;
    }
}