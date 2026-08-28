import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        boolean[]visited=new boolean[n+1];
        
        ArrayList<Integer>[]adj=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            adj[i]=new ArrayList<>();
        }
        for(int []e:edge){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(1,0));
        visited[1]=true;
        int max=0,curNum=0,curCost=0;
        while(!q.isEmpty()){
            Node cur=q.poll();
            curNum=cur.num;
            curCost=cur.cost;
            if(curCost>max){
                max=curCost;
                answer=1;
            }else if(curCost==max){
                answer++;
            }
            for(int nxt: adj[curNum]){
                if(!visited[nxt]){
                    q.add(new Node(nxt,curCost+1));
                    visited[nxt]=true;
                }
            }
        }
        
        return answer;
    }
}
class Node{
    int num, cost;
    
    public Node(int num,int cost){
        this.num=num;
        this.cost=cost;
    }
}