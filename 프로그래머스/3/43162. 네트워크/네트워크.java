import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[]visited=new boolean[n];
        for(int i=0;i<n;i++){
            Queue<Integer>q=new LinkedList<>();
            if(!visited[i]){
                visited[i]=true;
                q.add(i);
                answer++;
            }
            while(!q.isEmpty()){
                int cur=q.poll();
                for(int nxt=0;nxt<n;nxt++){
                    if(cur==nxt||computers[cur][nxt]==0||visited[nxt])continue;
                    q.add(nxt);
                    visited[nxt]=true;
                }
            }
        }
        return answer;
    }
}