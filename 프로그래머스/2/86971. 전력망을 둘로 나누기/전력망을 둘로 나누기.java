import java.util.*;
class Solution {
    static boolean[]visited;
    static ArrayList<Integer>[]next;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE-1;
        visited=new boolean[n+1];
        next=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            next[i]=new ArrayList<>();
        }
        for(int i=0;i<wires.length;i++){
            int a=wires[i][0];
            int b=wires[i][1];
            next[a].add(b);
            next[b].add(a);
        }
        for(int i=0;i<wires.length;i++){
            int a=wires[i][0];
            int b=wires[i][1];
            visited[a]=true;
            int tmp1=dfs(a,b);
            visited[b]=true;
            int tmp2=dfs(b,a);
            // System.out.println(i+"번: "+tmp1+" "+tmp2);
            int sum=tmp1-tmp2;
            sum=sum<0?-sum:sum;
            answer=Math.min(answer,sum);
            Arrays.fill(visited,false);
        }
        return answer;
    }
    static int dfs(int a,int b){
        int cnt=1;
        for(int nxt:next[a]){
            if(nxt!=b&&!visited[nxt]){
                visited[nxt]=true;
                cnt+=dfs(nxt,b);
            }
        }
        return cnt;
    }
}