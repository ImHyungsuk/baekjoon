import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList<Integer>[]adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        
        boolean[]visited=new boolean[n+1];
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(1,0));
        visited[1]=true;
        int max=0;
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(max==cur.cost) answer++;
            else if(max<cur.cost){
                answer=1;
                max=cur.cost;
            }
            
            for(int nxt:adj[cur.num]){
                if(!visited[nxt]){
                    visited[nxt]=true;
                    q.add(new Node(nxt,cur.cost+1));
                }
            }
        }
        
        
        return answer;
    }
}
class Node{
    int num,cost;
    public Node(int num, int cost){
        this.num=num;
        this.cost=cost;
    }
}