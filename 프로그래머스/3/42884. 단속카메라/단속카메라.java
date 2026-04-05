import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int loc=-30001;
        Arrays.sort(routes,(r1,r2)->r1[1]-r2[1]);
        for(int i=0;i<routes.length;i++){
            if(routes[i][0]>loc){
                answer++;
                loc=routes[i][1];
            }
        }
        return answer;
    }
}