import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[]dx={-1,1};
        boolean[]have=new boolean[n+1];
        Set<Integer>lostSet=new HashSet<>();
        Set<Integer>reserveSet=new HashSet<>();
        for(int l:lost)lostSet.add(l);
        for(int r:reserve)reserveSet.add(r);
        
        Set<Integer>intersection=new HashSet<>(lostSet);
        intersection.retainAll(reserveSet);
        
        lostSet.removeAll(intersection);
        reserveSet.removeAll(intersection);
    
        answer-=lostSet.size();
        Arrays.fill(have,true);
        for(int l:lostSet){
            have[l]=false;
        }
        for(int cur:reserveSet){
            for(int j=0;j<2;j++){
                int nxt=cur+dx[j];
                if(nxt<1||nxt>n) continue;
                if(!have[nxt]){
                    answer++;
                    have[nxt]=true;
                    break;
                }
            }
        }
        return answer;
    }
}