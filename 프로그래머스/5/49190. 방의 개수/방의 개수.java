import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        int[]dx={0,1,1,1,0,-1,-1,-1};
        int[]dy={1,1,0,-1,-1,-1,0,1};
        Set<Node>visitedNode=new HashSet<>();
        Set<Edge>visitedEdge=new HashSet<>();
        visitedNode.add(new Node(0,0));
        int x=0,y=0;
        for(int i=0;i<arrows.length;i++){
            int n=arrows[i];
            for(int j=0;j<2;j++){
                Node cur=new Node(x,y);
                x+=dx[n];
                y+=dy[n];
                Node nxt=new Node(x,y);
                if(visitedNode.contains(nxt)&&!visitedEdge.contains(new Edge(cur,nxt)))answer++;
                else {
                    visitedNode.add(nxt);
                }
                visitedEdge.add(new Edge(cur,nxt));
                visitedEdge.add(new Edge(nxt,cur));
            }
        }
        return answer;
    }
}

class Node{
    int x,y;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Node)) return false;
        
        Node o=(Node)obj;
        return this.x==o.x&&this.y==o.y;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
}

class Edge{
   Node from,to;
    Edge(Node from,Node to){
        this.from=from;
        this.to=to;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Edge)) return false;
        
        Edge o=(Edge)obj;
        return this.from.equals(o.from)&&this.to.equals(o.to)||
            this.from.equals(o.to)&&this.to.equals(o.from);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(from,to);
    }
}