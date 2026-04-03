import java.util.*;
class Solution {
    static ArrayList<Integer>[]next;
    public int solution(int n, int[][] wires) {
        int answer = 101;
        next=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            next[i]=new ArrayList<>();
        }
        for(int i=0;i<wires.length;i++){
            next[wires[i][0]].add(wires[i][1]);
            next[wires[i][1]].add(wires[i][0]);
        }
        for(int i=0;i<wires.length;i++){
            boolean[]visited=new boolean[n+1];
            visited[wires[i][0]]=true;
            visited[wires[i][1]]=true;
            int a=count(n,wires[i][0],wires,visited);
            int tmp=a>n/2?2*a-n:n-2*a;
            answer=answer>tmp?tmp:answer;
        }
        return answer;
    }

    static int count(int n,int cur,int[][]wires,boolean[]visited){
        int cnt=1;
        for(int nxt:next[cur]){
            if(!visited[nxt]){
                visited[nxt]=true;
                cnt+=count(n,nxt,wires,visited);
            }
        }
        return cnt;
    }
}