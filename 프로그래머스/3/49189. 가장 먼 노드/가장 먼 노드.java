import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Node>pq=new ArrayDeque<>();
        ArrayList<Integer>[]next=new ArrayList[n+1];
        boolean[]visited=new boolean[n+1];
        for(int i=1;i<=n;i++){
            next[i]=new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            int a=edge[i][0];
            int b=edge[i][1];
            next[a].add(b);
            next[b].add(a);
        }
        pq.add(new Node(1,0));
        visited[1]=true;
        int max=0;
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            if(max<cur.cost) {
                max=cur.cost;
                answer=1;
            }
            else if(max==cur.cost) {
                answer++;
                // System.out.printf("%d노드 %d비용 %d회\n",cur.num,cur.cost,answer);
            }
            for(int nxt:next[cur.num]){
                if(visited[nxt])continue;
                pq.add(new Node(nxt,cur.cost+1));
                visited[nxt]=true;
            }
        }
        return answer;
    }
}
class Node{
    int num,cost;
    public Node(int num,int cost){
        this.num=num;
        this.cost=cost;
    }
}