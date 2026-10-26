import java.util.*;
class Solution {
    public int solution(String name) {
        // System.out.println((int)('O'-'A')+" "+(int)('Z'-'O'));
        int answer = 0;
        int len=name.length();
        int move=len-1;
        boolean flag=false;
        for(int idx=0;idx<len;idx++){
            char c=name.charAt(idx);
            answer+=Math.min(c-'A','Z'-c+1);
            
            int next=idx+1;
            while(next<len && name.charAt(next)=='A')
                next++;
            
            move=Math.min(move,2*idx+len-next);
            move=Math.min(move,idx+2*(len-next));
        }
        return answer+move;
    }
}