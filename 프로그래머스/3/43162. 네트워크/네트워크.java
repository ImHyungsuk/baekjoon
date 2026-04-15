import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        answer=bfs(n,computers);
        return answer;
    }
    
    static int bfs(int n,int[][]map){
        int cnt=0;
        boolean[]visited=new boolean[n];
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            q.add(i);
            visited[i]=true;
            cnt++;
            while(!q.isEmpty()){
                int cur=q.poll();
                // System.out.println(cur);
                for(int nxt=0;nxt<n;nxt++){
                    if(cur==nxt || map[cur][nxt]!=1) continue;
                    if(visited[nxt]) continue;
                    q.add(nxt);
                    visited[nxt]=true;
                }
            }
        }
        return cnt;
    }
}