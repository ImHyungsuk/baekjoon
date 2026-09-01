import java.util.*;

class Solution {
    int[]dx={-1,1,0,0};
    int[]dy={0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][]map=new int[101][101];
        for(int []r:rectangle){
            int x1=r[0]*2,y1=r[1]*2;
            int x2=r[2]*2,y2=r[3]*2;
            for(int i=x1;i<=x2;i++){
                for(int j=y1;j<=y2;j++){
                    if((i==x1||i==x2||j==y1||j==y2)&&map[j][i]!=-1)
                        map[j][i]=1;
                    else
                        map[j][i]=-1;
                }
            }
        }
        answer=bfs(map,characterX*2,characterY*2,itemX*2,itemY*2)/2;
        return answer;
    }
    
    int bfs(int[][] map,int characterX,int characterY,int itemX,int itemY){
        boolean[][]visited=new boolean[map.length][map[0].length];
        Queue<Node>q=new LinkedList<>();
        q.add(new Node(characterX,characterY,0));
        visited[characterY][characterX]=true;
        int ret=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur.x==itemX&&cur.y==itemY){
                ret=Math.min(ret,cur.cnt);
            }
            for(int i=0;i<4;i++){
                int nX=cur.x+dx[i];
                int nY=cur.y+dy[i];
                if(nY<0||nX<0||nY>100||nX>100)continue;
                if(!visited[nY][nX]&&map[nY][nX]==1){
                    q.add(new Node(nX,nY,cur.cnt+1));
                    visited[nY][nX]=true;
                }
            }
        }
        return ret;
    }
}
class Node{
    int x,y,cnt;
    Node(int x,int y,int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}