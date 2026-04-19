import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int l=1,r=distance;
        while(l<=r){
            int mid=(l+r)/2;
            int remove=0;
            int prev=0;
            for(int rock:rocks){
                if(rock-prev<mid)
                    remove++;
                else
                    prev=rock;
            }
            if(distance-prev<mid)remove++;
            
            if(remove>n)r=mid-1;
            else {
                answer=mid;
                l=mid+1;
            }
        }
        return answer;
    }
}