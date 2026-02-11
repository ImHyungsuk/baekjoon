import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=answer) break;
            answer--;
        }
        return answer;
    }
}