import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(int[]r1,int[]r2)->r1[1]-r2[1]);
        int cnt=routes.length;
        int pre=-30001;
        for(int i=0;i<cnt;i++){
            if(pre<routes[i][0]){
                answer++;
                pre=routes[i][1];
            }
        }
        return answer;
    }
}