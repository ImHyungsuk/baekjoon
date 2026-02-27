import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(a,b)->a[1]-b[1]);
        
        int end=-30001;
        for(int[] r:routes){
            if(r[0]<=end) continue;
            end=r[1];
            answer++;
        }
        return answer;
    }
}