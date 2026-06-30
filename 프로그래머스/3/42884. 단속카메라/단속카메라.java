import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (r1,r2)->{
           if(r1[1]==r2[1])return r1[0]-r2[0];
            return r1[1]-r2[1];
        });
        int min=routes[0][1];
        answer++;
        for(int i=1;i<routes.length;i++){
            if(routes[i][0]>min){
                answer++;
                min=routes[i][1];
            }
        }
        return answer;
    }
}