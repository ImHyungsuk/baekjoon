import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    
    static int bfs(int[][]maps){
        int r=maps.length;
        int c=maps[0].length;
        int []dx={-1,1,0,0};
        int []dy={0,0,-1,1};
        int min=r*c+1;
        boolean [][]visited=new boolean[r][c];
        Queue<Node>q=new ArrayDeque<>();
        q.add(new Node(0,0,1));
        visited[0][0]=true;
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur.x==c-1&&cur.y==r-1) min=Math.min(min,cur.value);
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];
                if(nx<0||nx>=c||ny<0||ny>=r) continue;
                if(maps[ny][nx]==0||visited[ny][nx]) continue;
                visited[ny][nx]=true;
                q.add(new Node(nx,ny,cur.value+1));
            }
        }
        min=min==r*c+1?-1:min;
        return min;
    }
}
class Node{
    int x,y,value;
    public Node(int x,int y,int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
}